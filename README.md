# QuPath
This repository contains QuPath Scripts written for users of the IGMM AIR facility.

Keep reading for some help regarding using the scripts.

# How to use a QuPath Script 

**Opening a QuPath Script in the script editor**
*	The easiest way to open a QuPath script is to just drag and drop the file on to the main QuPath console. 
*	You can also go to ‘Automate’ > ‘Show Script Editor’ to open the script editor and go to ‘File’ > ‘Open’ and locate the script.

**Running a script for a single image**
*	To run a script for an image, it is simply a matter of opening both the image and the script, and selecting ‘Run’ > ‘Run’ from the menu above the Script Editor (i.e. the window containing the script).

**Running a script for multiple images**
*	To run the script on for some or all of the images in your QuPath Project you can go to ‘Run’ > ‘Run for project’. This will bring up a window containing all the images in the project on the left side, and an empty list on the right. Move the images you want the script to run on over to the right side and press okay for those images to be processed.

**Notes**
*	QuPath scripts are written in the language Groovy and thus the filenames should end in the extension ‘.groovy’.
*	Please download and use the most up-to-date version of QuPath (currently 0.2.0 – m8). These scripts are tested for compatibility with new releases.

**Further links**
*	QuPath official script examples 
https://github.com/qupath/qupath/wiki/Scripting-examples
