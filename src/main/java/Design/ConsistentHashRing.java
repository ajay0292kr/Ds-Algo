package Design;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ConsistentHashRing {
    private final Map<Long, String> ring = new HashMap<>();
    private final TreeSet<Long> sortedKeys = new TreeSet<>();
    private final int replicas;

    public ConsistentHashRing(int replicas) {
        this.replicas = replicas;
    }

    public ConsistentHashRing() {
        this(100); // more replicas for better distribution
    }

    // Better hash using SHA-256
    private long getHash(String value) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(value.getBytes());
            // Take first 8 bytes and convert to long
            return ((long) (digest[0] & 0xFF) << 56) |
                    ((long) (digest[1] & 0xFF) << 48) |
                    ((long) (digest[2] & 0xFF) << 40) |
                    ((long) (digest[3] & 0xFF) << 32) |
                    ((long) (digest[4] & 0xFF) << 24) |
                    ((long) (digest[5] & 0xFF) << 16) |
                    ((long) (digest[6] & 0xFF) << 8)  |
                    ((long) (digest[7] & 0xFF));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void addNode(String node) {
        for (int i = 0; i < replicas; i++) {
            long replicaKey = getHash(node + "_" + i);
            ring.put(replicaKey, node);
            sortedKeys.add(replicaKey);
        }
    }

    public void removeNode(String node) {
        for (int i = 0; i < replicas; i++) {
            long replicaKey = getHash(node + "_" + i);
            ring.remove(replicaKey);
            sortedKeys.remove(replicaKey);
        }
    }

    public String getNode(String key) {
        if (ring.isEmpty()) {
            return "";
        }

        long hashValue = getHash(key);
        Long targetKey = sortedKeys.ceiling(hashValue);

        if (targetKey == null) {
            targetKey = sortedKeys.first();
        }

        return ring.get(targetKey);
    }
    public static void main(String[] args) {
        ConsistentHashRing hashRing = new ConsistentHashRing(50); // 50 virtual nodes

        hashRing.addNode("Node_A");
        hashRing.addNode("Node_B");
        hashRing.addNode("Node_C");

        String[] keys = {"first_key", "apple", "banana", "orange", "grape", "mango"};

        for (String key : keys) {
            System.out.println("Key '" + key + "' → " + hashRing.getNode(key));
        }
    }
}
