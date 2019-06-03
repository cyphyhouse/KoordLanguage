/**
 * Type system for Koord
 */
class Type {

    private static final int IntVal = 0;
    private static final int FloatVal = 1;
    private static final int BoolVal = 2;
    private static final int QueueVal = 3;
    private static final int PosVal = 4;
    private static final int ArrayVal = 5;
    private static final int StringVal = 6;

    public static final Type Int = new Type(IntVal);
    public static final Type Float = new Type(FloatVal);
    public static final Type Bool = new Type(BoolVal);
    public static final Type Queue = new Type(QueueVal);
    public static final Type Pos = new Type(PosVal);
    public static final Type String = new Type(StringVal);


    /**
     * For types that have another type inside of them, such as Arrays.
     * @return the inner type
     */
    public Type getInnerType() {
        return innerType;
    }

    private Type innerType = null;
    private final int code;

    /**
     * Constructs an array type from the inner type
     * @param inner the inner type
     * @return the type wrapped in an arry
     */
    public static Type Array(Type inner) {
        var ret =  new Type(ArrayVal);
        ret.innerType = inner;
        return ret;

    }

    private Type(int code) {
        this.code = code;
    }

    /**
     * Check if one type is equal to another type.
     * You should use this method instead of == because == will not work
     * with arrays.
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other) {
        Type otherType = (Type) other;
        if (innerType == null) {
            return this.code == ((Type) otherType).code;
        }

        return this.code == ((Type) other).code && this.innerType.equals(((Type) other).innerType);
    }

    /**
     * Whether the type is an array
     * @return whether teh type is an arary
     */
    public boolean isArray() {
        return this.code == ArrayVal;
    }


    /**
     * Create a human readable form of the type
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
        }
        return "unknown";
    }

}
