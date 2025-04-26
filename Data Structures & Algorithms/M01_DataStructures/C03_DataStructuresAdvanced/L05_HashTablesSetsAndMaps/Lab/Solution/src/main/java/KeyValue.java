import java.util.Objects;

public class KeyValue<Key, Value> {

    private Key key;
    private Value value;

    public KeyValue(Key key, Value value) {
        this.setKey(key);
        this.setValue(value);
    }

    public Key getKey() {
        return this.key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Value getValue() {
        return this.value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return this.combineHashCodes(this.getKey().hashCode(), this.getValue().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyValue<?, ?> keyValue = (KeyValue<?, ?>) o;
        return Objects.equals(key, keyValue.key) &&
                Objects.equals(value, keyValue.value);
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.getKey(), this.getValue());
    }

    private int combineHashCodes(int h1, int h2) {
        return ((h1 << 5) + h1) ^ h2;
    }
}