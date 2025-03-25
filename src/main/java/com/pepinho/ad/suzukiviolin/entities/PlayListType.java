package com.pepinho.ad.suzukiviolin.entities;

/**
 * Enumerado que representa los tipos de listas de piezas que se pueden crear.
 *
 * @version 1.0 - 2021-09-10
 * @since 1.0 - 2021-09-10
 */
public enum PlayListType {
    REPERTORIO(1), ESCALAS(2), ARPEGIOS(3), TECNICA(4),
    ESTUDIOS(5), LIBRO(6), CONCIERTO(7), OTROS(8);

    private Integer idTipoLista;

    private PlayListType(Integer idTipoLista) {
        this.idTipoLista = idTipoLista;
    }

    public Integer getIdTipoLista() {
        return idTipoLista;
    }

    public void setIdTipoLista(Integer idTipoLista) {
        this.idTipoLista = idTipoLista;
    }

    public static PlayListType fromId(Integer idTipoLista) {
        for (PlayListType tl : PlayListType.values()) {
            if (tl.getIdTipoLista().equals(idTipoLista)) {
                return tl;
            }
        }
        return null;
    }

    public static PlayListType fromString(String tipoLista) {
        for (PlayListType tl : PlayListType.values()) {
            if (tl.name().equalsIgnoreCase(tipoLista)) {
                return tl;
            }
        }
        return null;
    }

    public static String toString(PlayListType playListType) {
        return playListType.name();
    }

    public static String[] toStringArray() {
        PlayListType[] values = PlayListType.values();
        String[] strings = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            strings[i] = values[i].name();
        }
        return strings;
    }

    @Override
    public String toString() {
        // con la primera letra en mayúsculas y el resto en minúsculas
        String name = name();
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
