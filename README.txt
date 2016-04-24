
## Run the following commands
# (1) Creates ./gradlew
# (2) Creates a jar
# (3) Parses a pdf into sentences and than creates a natural language graph for each of the sentences

(1) gradle wrapper
(2) ./gradlew clean fatJar
(3) java -cp .:./build/libs/rsdets1-tika-all-1.0.jar rsdets1.PdfParse "https://www.heart.org/idc/groups/ahamah-public/@wcm/@sop/@smd/documents/downloadable/ucm_470704.pdf" 
