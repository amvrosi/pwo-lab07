package pwo.seq;

import java.util.stream.Stream;

public enum SeqType {
    FIB,
    LUC,
    TRI;

    private static final int B = 0;
    private static final String FIX_SEQTYPE = "Problem in " + SeqType.class.getName();

    static {
        Stream.of(SeqType.values()).forEach(t -> {
            int L = t.toString().length();
            if (L != 3) {
                throw new IllegalStateException(FIX_SEQTYPE);
            }
        });
    }

    public static SeqType fromString(String type) {
        try {
            return valueOf(type.trim().substring(B, type.length()).toUpperCase());
        } catch (NullPointerException | StringIndexOutOfBoundsException | IllegalArgumentException ex) {
            return null;
        }
    }

    public Generator getGenerator() {
        switch (this) {
            case FIB:
                return new FibonacciGenerator();
            case LUC:
                return new LucasGenerator();
            case TRI:
                return new TribonacciGenerator();
            default:
                throw new IllegalStateException(FIX_SEQTYPE);
        }
    }
}
