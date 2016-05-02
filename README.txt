
## Author: Richard Shane Detsch
# Used Apache Tika extract pdf content
# Used Apache OpenNLP to parse pdf conent into sentences that are than read to a file
# Used Python nltk to parse each sentense into its sentence parts

## Install Groovy, Gradle, Python 2.6 or 2.7 and Pip

## Do Once
# Configure Python to use the nltk natural language package
(1) cd scripts
(2) pip install nltk
(3) mkdir nltk_data
(4) python -m nltk.downloader  # An application will pop up asking you what nlp library you want to download
	(4.1) Edit the pop up's "Download Directory" to be ${project.home}/rsdets1/scripts/nltk_data

## Run the following commands
# (1) Creates ./gradlew
# (2) Creates a jar
# (3) Parses a pdf into sentences and writes those sentences one line at a time to a file
# (4) A python script to generate the natural laungage tagged output for each sentence

(1) gradle wrapper (Run only once)
(2) ./gradlew clean fatJar
(3) ./gradlew runPdfParserJar -Ppdffile=https://www.heart.org/idc/groups/ahamah-public/@wcm/@sop/@smd/documents/downloadable/ucm_470704.pdf
(4) ./gradlew runPyNlp

