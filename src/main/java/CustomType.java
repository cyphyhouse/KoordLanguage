import java.util.Map;

public class CustomType {
    private Map<String, Type> fields;
    private String name;

    public CustomType(Map<String, Type> fields, String name) {
        this.fields = fields;
        this.name = name;
    }

    public Map<String, Type> getFields() {
        return fields;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        return name.equals(((CustomType) other).name);
    }

    @Override
    public String toString() {
        return name;
    }


}
