package rsdets1;

/**
 * Created by richard.detsch on 4/23/16.
 */


import java.io.*;
import java.net.URL;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;



public class PdfParse {

    public static void main(final String[] args) throws Exception {


        URL texturl = null;
        if(args.length > 0) {
            texturl = new URL(args[0]);
        } else {
            texturl = new URL("http://www.diabeteswellness.net/sites/default/files/What%20is%20Diabetes.pdf");
        }

        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();

        System.out.println("opening connection");
        InputStream textin = null;

        File fout = new File("scripts/processFile.txt");
        FileOutputStream fos = new FileOutputStream(fout);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));


        try {
            textin = texturl.openStream();
            ParseContext pcontext = new ParseContext();
            PDFParser pdfparser = new PDFParser();
            pdfparser.parse(textin, handler, metadata, pcontext);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != textin) {
                textin.close();
            }
        }

        System.out.println("Metadata of the PDF:");
        String[] metadataNames = metadata.names();

        for(String name : metadataNames) {
            System.out.println(name+ " : " + metadata.get(name));
        }

        URL sentUrl = new URL("http://maven.tamingtext.com/opennlp-models/models-1.5/en-sent.bin");
        InputStream sin = null;
        try {
            sin = sentUrl.openStream();
            SentenceModel model = new SentenceModel(sin);
            SentenceDetectorME sdetector = new SentenceDetectorME(model);
            String sentences[] = sdetector.sentDetect(handler.toString());
            int count = 0;
            for (String senctence: sentences) {
                senctence = senctence.replace("\n", "").replace("\r", "").replaceAll("[^\\x00-\\x7F]", "");
                //System.out.println("Sentence " + ++count + " is: " + senctence);
                bw.write(senctence);
                bw.newLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(null != sin) {
                sin.close();
            }
            if(null != bw) {
                bw.close();
            }
        }

    }
}
