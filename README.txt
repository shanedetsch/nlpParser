
## Run the following commands
# (1) Creates ./gradlew
# (2) Creates a jar
# (3) Parses a pdf into sentences and writes those sentences one line at a time to a file
# (4) A python script to generate the natural laungage tagged output for each sentence

(1) gradle wrapper (Run only once)
(2) ./gradlew clean fatJar
(3) ./gradlew runPdfParserJar -Ppdffile=https://www.heart.org/idc/groups/ahamah-public/@wcm/@sop/@smd/documents/downloadable/ucm_470704.pdf
(4) ./gradlew runPyNlp

## Configure Python to use the nltk natural language package
(1) cd scripts
(2) pip install nltk
(3) mkdir nltk_data
(4) python -m nltk.downloader  # An application will pop up asking you what nlp library you want to download
	(4.1) Edit the pop up's "Download Directory" to be ${project.home}/rsdets1/scripts/nltk_data

## You can also use Google's nlp parser 
# In the same directory you clones this repo, clone this repo https://github.com/tensorflow/models.git
# by following these instructions https://github.com/tensorflow/models/tree/master/syntaxnet
(1) gradle wrapper (Run only once)
(2) ./gradlew clean fatJar
(3) ./gradlew runPdfParserJar -Ppdffile=https://www.heart.org/idc/groups/ahamah-public/@wcm/@sop/@smd/documents/downloadable/ucm_470704.pdf
(4) ./gradlew runGoogleNlp


## Example of a sentence parsed by Google

Input: Nearly 787 , 000 people in the U.S. died from heart disease , stroke and other cardiovascular diseases in 2011 .
Parse:
died VBD ROOT
 +-- Nearly RB prep
 |   +-- 787 CD pobj
 +-- , , punct
 +-- people NNS nsubj
 |   +-- 000 CD num
 |   +-- in IN prep
 |       +-- U.S. NNP pobj
 |           +-- the DT det
 +-- from IN prep
 |   +-- disease NN pobj
 |       +-- heart NN nn
 |       +-- , , punct
 |       +-- stroke NN conj
 |       +-- and CC cc
 |       +-- diseases NNS conj
 |           +-- other JJ amod
 |           +-- cardiovascular JJ amod
 +-- in IN prep
 |   +-- 2011 CD pobj
 +-- . . punct


# Example of the same sentenced parsed using python nltk

Processing sentence 5: 
     Nearly 787,000 people in the U.S. died from heart disease, stroke and other cardiovascular diseases in 2011.

,, ,
., .
and, CC
2011, CD
787,000, CD
the, DT
in, IN
from, IN
cardiovascular, JJ
other, JJ
disease, NN
stroke, NN
heart, NN
U.S., NNP
people, NNS
diseases, NNS
Nearly, RB
died, VBD

