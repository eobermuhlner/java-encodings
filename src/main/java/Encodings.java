import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

public class Encodings {

	private static final String TEST_STRING = ""
	   + "    German: ÄÖÜ äöü\n"
	   + "    French: ÁÀÂÉÈÊ áàâéèê Œ œ Ÿÿ\n"
	   + "    Spanish: ñ\n"
	   + "    Czech: 	ČčĎďĚěŇňŘřŠšŤťŮůŽž\n"
	   + "    Special: ¤ € ¼ ½ ¾ ²";

	public static void main(String[] args) {
		List<String> encodings = Arrays.asList(
		   //"US-ASCII",
		   "UTF-8",
		   "ISO-8859-1",
		   //"ISO-8859-2",
		   //"ISO-8859-3",
		   //"ISO-8859-4",
		   //"ISO-8859-9",
		   //"ISO-8859-13",
		   "ISO-8859-15",
		   "windows-1252");

		for (String fromEncoding : encodings) {
			for (String toEncoding : encodings) {
				printEncoding(fromEncoding, toEncoding);
			}
		}
	}

	private static void printEncoding(String encoding) {
		printEncoding(encoding, encoding);
	}

	private static void printEncoding(String fromEncoding, String toEncoding) {
		try {
			if (fromEncoding.equals(toEncoding)) {
				System.out.println("## " + fromEncoding);
			}
			else {
				System.out.println("## " + fromEncoding + " to " + toEncoding);
			}

			System.out.println(new String(TEST_STRING.getBytes(fromEncoding), toEncoding));
			System.out.println();
		}
		catch (UnsupportedEncodingException ex) {
			System.out.println("Encoding not supported: " + toEncoding);
		}
	}
}
