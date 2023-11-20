public class Main {
    public static void main(String[] args) throws Exception {
        String str = "aabcdedad";
        HuffmanCoder hf = new HuffmanCoder(str);
        String codedStr = hf.encode(str);
        System.out.println(codedStr);
        String decodedStr = hf.decode(codedStr);
        System.out.println(decodedStr.equals(str));
    }
}