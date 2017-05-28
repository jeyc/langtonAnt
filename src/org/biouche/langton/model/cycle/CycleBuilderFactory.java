package org.biouche.langton.model.cycle;

/**
 * Fabrique unique de CycleBuilder. Thread-safe.
 */
public final class CycleBuilderFactory {

    private static CycleBuilderFactory factory;

    private CycleBuilderFactory() {}

    public static CycleBuilderFactory getFactory() {
        if (factory == null)
            synchronized (CycleBuilderFactory.class) {
            if (factory == null)
                factory = new CycleBuilderFactory();
        }
        return factory;
    }

    public CycleBuilder createCycleBuilder() {
        return new CycleBuilderImpl();
    }

}
