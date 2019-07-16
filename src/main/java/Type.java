import java.util.HashMap;
import java.util.Map;

/**
 * Used the represent types in Kooord
 */
public class Type {

    private static final int IntVal = 0;
    private static final int FloatVal = 1;
    private static final int BoolVal = 2;
    private static final int QueueVal = 3;
    private static final int PosVal = 4;
    private static final int ArrayVal = 5;
    private static final int StringVal = 6;
    private static final int StreamVal = 7;
    private static final int CustomVal = 8;

    /**
     * Boolean type
     */
    public static final Type Bool = new Type(BoolVal);
    /**
     * Integer type
     */
    public static final Type Int = new Type(IntVal);
    /**
     * Floating point type
     */
    public static final Type Float = new Type(FloatVal);
    /**
     * String type
     */
    public static final Type String = new Type(StringVal);
    /**
     * Position type
     */
    public static final Type Pos = new Type(PosVal);
    /**
     * Stream type
     */
    public static final Type Stream = new Type(StreamVal);

    private final int code;
    private Type innerType = null;

    private Type(int code) {
        this.code = code;
    }

    private static Map<String, Type> customTypes = new HashMap<>();
    private CustomType customType;

    public static void createType(Map<String, Type> fields, String name) {
        var ret = new Type(CustomVal);

        ret.customType = new CustomType(fields, name);
        customTypes.put(name, ret);
    }

    /**
     * Constructs an array type from the inner type
     *
     * @param inner the inner type
     * @return the type wrapped in an arry
     */
    public static Type Array(Type inner) {
        var ret = new Type(ArrayVal);
        ret.innerType = inner;
        return ret;

    }

    public static Type CustomType(String name) {
        return customTypes.get(name);
    }

    public CustomType getCustomType() {
        return customType;
    }

    /**
     * For types that have another type inside of them, such as Arrays.
     *
     * @return the inner type
     */
    public Type getInnerType() {
        return innerType;
    }

    /**
     * Check if one type is equal to another type.
     * You should use this method instead of == because == will not work
     * with arrays.
     *
     * @param other the other type
     * @return whether they are equal
     */
    @Override
    public boolean equals(Object other) {

        if (customType != null && ((Type) other).customType != null) {
            return ((Type) other).customType.equals(this.customType);
        }
        if (innerType == null) {
            return this.code == ((Type) other).code;
        }

        return this.code == ((Type) other).code && this.innerType.equals(((Type) other).innerType);
    }

    /**
     * Whether the type is an array
     *
     * @return whether the type is an array
     */
    public boolean isArray() {
        return this.code == ArrayVal;
    }


    /**
     * Create a human readable form of the type
     *
     * @return string
     */
    @Override
    public String toString() {
        switch (this.code) {
            case IntVal:
                return "Int";
            case PosVal:
                return "Pos";
            case BoolVal:
                return "Bool";
            case FloatVal:
                return "Float";
            case ArrayVal:
                return "[" + this.innerType.toString() + "]";
            case StringVal:
                return "String";
            case StreamVal:
                return "Stream";
            case CustomVal:
                return this.customType.toString() + customType.getFields().toString();
        }
        return "unknown";
    }


    /**
     * Creates the type to use in the generated python
     *
     * @return the python type
     */
    public String python() {
        switch (this.code) {
            case IntVal:
                return "int";
            case PosVal:
                return "Pose";
            case BoolVal:
                return "bool";
            case FloatVal:
                return "float";
            case ArrayVal:
                return "list";
            case StringVal:
                return "str";
            case StreamVal:
                return "IO";
            case CustomVal:
                return customType.getName();
        }
        return "unknown";
    }


}
