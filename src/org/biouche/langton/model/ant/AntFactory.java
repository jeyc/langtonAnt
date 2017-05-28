package org.biouche.langton.model.ant;

/**
 * Créé par jerome le 07/01/2016.
 */
public final class AntFactory {

    private static AntFactory factory;

    private AntFactory() {}

    public static AntFactory getFactory() {
        if (factory == null)
            synchronized (AntFactory.class) {
                if (factory == null)
                    factory = new AntFactory();
            }
        return factory;
    }

    public Ant createAnt() {
        return new AntImpl();
    }

}
