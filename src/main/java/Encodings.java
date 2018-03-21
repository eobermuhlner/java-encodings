import java.io.UnsupportedEncodingException;

public class Encodings {

	public enum Encoding {
		UTF_8("UTF-8", "Unicode 8-bit"),
//		UTF_16("UTF-16", "Unicode 16-bit"),
//		UTF_16BE("UnicodeBigUnmarked", "Unicode 16-bit BigEndian"),
//		UTF_16LE("UnicodeLittleUnmarked", "Unicode 16-bit LittleEndian"),
//		UTF_32("UTF-32", "Unicode 32-bit"),
//		UTF_32BE("UTF_32BE", "Unicode 32-bit"),
//		UTF_32LE("UTF_32LE", "Unicode 32-bit"),
//		UTF_32BE_BOM("UTF_32BE_BOM", "Unicode 32-bit BigEndian with ByteOrderMark"),
//		UTF_32LE_BOM("UTF_32LE_BOM", "Unicode 32-bit LittleEndian with ByteOrderMark"),
//		UTF_16BE_BOM("UnicodeBig", "Unicode 16-bit BigEndian with ByteOrderMark"),
//		UTF_16LE_BOM("UnicodeLittle", "Unicode 16-bit LittleEndian with ByteOrderMark"),
		ASCII("US-ASCII", "ASCII"),
		ISO_8859_1("ISO-8859-1", "Latin Alphabet No. 1"),
		ISO_8859_2("ISO-8859-2", "Latin Alphabet No. 2"),
		ISO_8859_4("ISO-8859-4", "Latin Alphabet No. 4"),
		ISO_8859_5("ISO-8859-5", "Latin/Cyrillic Alphabet"),
		ISO_8859_7("ISO-8859-7", "Latin/Greek Alphabet"),
		ISO_8859_9("ISO-8859-9", "Latin Alphabet No. 5"),
		ISO_8859_13("ISO-8859-13", "Latin Alphabet No. 7"),
		ISO_8859_15("ISO-8859-15", "Latin Alphabet No. 9"),
		KOI8_R("KOI8-R", "Russian"),
		KOI8_U("KOI8-R", "Ukrainian"),
		CP_437("Cp437", "MS-DOS United States, Australia, New Zealand, South Africa"),
		CP_775("Cp775", "MS-PC Baltic"),
		CP_737("Cp775", "PC Greek"),
		CP_850("Cp850", "MS-DOS Latin-1"),
		CP_852("Cp852", "MS-DOS Latin-2"),
		CP_855("Cp855", "IBM Cyrillic"),
		CP_857("Cp857", "IBM Turkish"),
		CP_858("Cp858", "MS-DOS Latin-1 with Euro"),
		CP_862("Cp862", "PC Hebrew"),
		CP_866("Cp866", "MS-DOS Russian"),
		CP_874("Cp874", "IBM Thai"),
		CP_1250("Cp1250", "Windows Eastern European"),
		CP_1251("Cp1251", "Windows Cyrillic"),
		CP_1252("Cp1252", "Windows Latin-1"),
		CP_1253("Cp1253", "Windows Greek"),
		CP_1254("Cp1254", "Windows Turkish"),
		CP_1257("Cp1257", "Windows Baltic");

		public final String code;
		public final String name;

		Encoding(String code, String name) {
			this.code = code;
			this.name = name;
		}
	}

	private static final String TEST_STRING = ""
	   + "    German:   ÄÖÜ äöüß\n"
	   + "    French:   ÁÀÂÉÈÊŒŸ áàâéèêœÿ\n"
	   + "    Spanish:  Ñ ñ\n"
	   + "    Czech:    ČĎĚŇŘŠŤŮŽ čďěňřšťůž\n"
	   + "    Cyrillic: АБВГДЕЁЖЗИЙІЇ абвгдеёжзийії\n"
	   + "    Special:  ¤ € ¼ ½ ¾ ²";

	public static void main(String[] args) {
		for (Encoding fromEncoding : Encoding.values()) {
			for (Encoding toEncoding : Encoding.values()) {
				printEncoding(fromEncoding, toEncoding);
			}
		}
	}

	private static void printEncoding(Encoding fromEncoding, Encoding toEncoding) {
		try {
			if (fromEncoding.equals(toEncoding)) {
				System.out.println("## " + fromEncoding.code + " (" + fromEncoding.name + ")");
			}
			else {
				System.out.println("## " + fromEncoding.code + " (" + fromEncoding.name + ") to " + toEncoding.code + " (" + toEncoding.name + ")");
			}

			System.out.println(new String(TEST_STRING.getBytes(fromEncoding.code), toEncoding.code));
			System.out.println();
		}
		catch (UnsupportedEncodingException ex) {
			System.out.println("Encoding not supported: " + toEncoding.code);
		}
	}
}
