import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HuffmanCoder {
    HashMap<Character, String> encoder;
    HashMap<String, Character> decoder;

    private class Node implements Comparable<Node> {
        Character data;
        int cost;
        Node left;
        Node right;

        public Node(Character data, int cost) {
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public HuffmanCoder(String feeder) throws Exception {
        // step 1 :- creating a frequency hashmap
        HashMap<Character, Integer> fmap = new HashMap<>();
        for (int i = 0; i < feeder.length(); i++) {
            fmap.put(feeder.charAt(i), fmap.getOrDefault(feeder.charAt(i), 0) + 1);
        }

        // step 2 :- creating a min-heap for storing nodes
        Heap<Node> minHeap = new Heap<>();
        Set<Map.Entry<Character, Integer>> entrySet = fmap.entrySet();

        for (Map.Entry<Character, Integer> entry : entrySet) {
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.insert(node);
        }

        // step 3 :- removing 2 elements from min-heap and combine
        while (minHeap.size() != 1) {
            Node first = minHeap.remove();
            Node second = minHeap.remove();

            Node newNode = new Node('\0', first.cost + second.cost);
            newNode.left = first;
            newNode.right = second;

            minHeap.insert(newNode);
        }

        // get the root of the tree
        Node root = minHeap.remove();

        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        // create encode and decode hashmap
        initEncoderAndDecoder(root, "");
    }

    private void initEncoderAndDecoder(Node root, String path) {
        if (root == null) {
            return;
        }

        // encountered a character node
        if (root.left == null && root.right == null) {
            this.encoder.put(root.data, path);
            this.decoder.put(path, root.data);
        }

        // traverse the left and right subtree
        initEncoderAndDecoder(root.left, path + "0");
        initEncoderAndDecoder(root.right, path + "1");
    }

    public String encode(String str) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            ans.append(encoder.get(str.charAt(i)));
        }

        return ans.toString();
    }

    public String decode(String encodedStr) {
        StringBuilder ans = new StringBuilder();
        String currCode = "";

        for (int i = 0; i < encodedStr.length(); i++) {
            currCode += encodedStr.charAt(i);
            // if currCode happens to be one of the key of decoder hashmap
            if (decoder.containsKey(currCode)){
                ans.append(decoder.get(currCode));
                currCode = "";
            }
        }

        return ans.toString();
    }
}
