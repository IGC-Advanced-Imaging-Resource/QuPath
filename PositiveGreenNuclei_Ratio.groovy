/**
 * Script count positive green nuclei in a QuPath project
 * Written for mTEC Analysis by Pete Tennant with ND2 series files from Thunder
 *
 * Because green nuclei are wanted but not green cells, a measurement called "Ratio" is created which is the nucleus mean intensity divided by cytoplasm mean intensity
 * Then a ratio threshold is picked between high and low
 * This ratio number will need checked if imaging conditions change
 * 
 * @author Laura Murphy
 * 
 * Note: please check channel names are correct!
 * 
 */



setImageType('FLUORESCENCE');
clearAllObjects();

createSelectAllObject(true);
runPlugin('qupath.imagej.detect.cells.WatershedCellDetection', '{"detectionImage": "DAPI Quad",  "requestedPixelSizeMicrons": 0.5,  "backgroundRadiusMicrons": 45.0,  "medianRadiusMicrons": 0.0,  "sigmaMicrons": 1.5,  "minAreaMicrons": 45.0,  "maxAreaMicrons": 200.0,  "threshold": 75.0,  "watershedPostProcess": true,  "cellExpansionMicrons": 1.0,  "includeNuclei": true,  "smoothBoundaries": true,  "makeMeasurements": true}');

detections = getDetectionObjects()

detections.each{
    ratio = measurement(it, "Nucleus: GFP  Quad mean")/ measurement(it, "Cytoplasm: GFP  Quad mean")
    it.getMeasurementList().putMeasurement("Ratio", ratio)
    }
  
setCellIntensityClassifications("Ratio",1.2)

positiveColour = getColorRGB(255,0,255)
getPathClass("Positive").setColor(positiveColour)

negativeColour = getColorRGB(0,255,255)
getPathClass("Negative").setColor(negativeColour)

fireHierarchyUpdate()

def name = getProjectEntry().getImageName() + '.txt'
def path = buildFilePath(PROJECT_BASE_DIR, 'annotation results')
mkdirs(path)
path = buildFilePath(path, name)
saveAnnotationMeasurements(path)
print 'Results exported to ' + path
