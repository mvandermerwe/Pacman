#!/bin/sh

#  solvePuzzle.shell.sh
#
#  Uses our Java project Pacman to solve a pacman puzzle with the best solution
#  then uses python script to run the solution.
#
#  Created by Mark Van der Merwe on 3/29/17.
#

if [[ $# -ne 2 ]] ; then
    echo 'Must provide: mazeFileName.txt mazeSolutionFileName.txt'
    exit 0
fi

FILENAME=$1
OUTPUTFILENAME=$2

java -jar pacman/pacmanJar.jar $FILENAME $OUTPUTFILENAME

cd pacman/
python pacman.py -l $OUTPUTFILENAME -p auto -z 0.5