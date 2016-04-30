
## Run the following commands
# (1) Creates ./gradlew
# (2) Creates a jar
# (3) Parses a pdf into sentences and writes those sentences one line at a time to a file
# (4) A python script to generate the natural laungage tagged output for each sentence

(1) gradle wrapper (Run only once)
(2) ./gradlew clean fatJar
(3) java -cp .:./build/libs/rsdets1-tika-all-1.0.jar rsdets1.PdfParse "https://www.heart.org/idc/groups/ahamah-public/@wcm/@sop/@smd/documents/downloadable/ucm_470704.pdf" 
(4) ./gradlew runPyNlp

## Configure Python to use the nltk natural language package
(1) cd scripts
(2) pip install nltk
(3) mkdir nltk_data
(4) python -m nltk.downloader 
	(3.1) Edit the pop up's "Download Directory" to be ${project.home}/rsdets1/scripts/nltk_data
