package Collections;

import java.util.Map;
import java.util.Objects;

class CustomKey {
    private final String keyPart1;
    private final int keyPart2;

    public CustomKey(String keyPart1, int keyPart2) {
        this.keyPart1 = keyPart1;
        this.keyPart2 = keyPart2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyPart1, keyPart2); // Generates a good hash code
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CustomKey that = (CustomKey) obj;

        return keyPart2 == that.keyPart2 && Objects.equals(keyPart1, that.keyPart1);
    }
}
public class CustomKeyTest {
    public static void main(String[] args) {
        Map<CustomKey, String> map = new java.util.HashMap<>();

        CustomKey key1 = new CustomKey("Test", 123);
        CustomKey key2 = new CustomKey("Test", 123); // Logically the same key

        map.put(key1, "Value1");

        System.out.println(map.get(key2)); //
    }
}
