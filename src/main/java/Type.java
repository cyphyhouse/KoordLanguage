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


    public Type getInnerType() {
        return innerType;
    }

    private Type innerType = null;
    private final int code;

    public static Type Array(Type inner) {
        var ret =  new Type(ArrayVal);
        ret.innerType = inner;
        return ret;

    }

    private Type(int code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object other) {
        Type otherType = (Type) other;
        if (innerType == null) {
            return this.code == ((Type) otherType).code;
        }

        return this.code == ((Type) other).code && this.innerType.equals(((Type) other).innerType);
    }

    public boolean isArray() {
        return this.code == ArrayVal;
    }

}
