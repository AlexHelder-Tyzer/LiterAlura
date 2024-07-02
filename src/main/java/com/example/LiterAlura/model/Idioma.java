package com.example.LiterAlura.model;

public enum Idioma {
    ES("[es]", "Español", "Spanish"),
    EN("[en]", "Ingles", "English"),
    FR("[fr]", "Frances", "French"),
    PT("[pt]", "Portugues", "Portuguese");

    private String idiomaGutendex;
    private String idiomaLiteraluraEs;
    private String idiomaLiteraluraEn;

    Idioma(String idiomaGutendex, String idiomaLiteralura, String idiomaLiteraluraEn){
        this.idiomaGutendex = idiomaGutendex;
        this.idiomaLiteraluraEs = idiomaLiteralura;
        this.idiomaLiteraluraEn = idiomaLiteraluraEn;
    }

    public static Idioma fromGutendex(String text){
        for(Idioma idioma : Idioma.values()){
            if(idioma.idiomaGutendex.equalsIgnoreCase(text)){
                return idioma;
            }
        }
        throw new IllegalArgumentException("Idioma no econtrado!!" + text);
    }

    public static Idioma fromEspanhol(String text){
        for(Idioma idioma : Idioma.values()){
            if(idioma.idiomaLiteraluraEs.equalsIgnoreCase(text)){
                return idioma;
            }
        }
        throw new IllegalArgumentException("Idioma no econtrado!!" + text);
    }

    public static Idioma fromEnglish(String text){
        for(Idioma idioma : Idioma.values()){
            if(idioma.idiomaLiteraluraEn.equalsIgnoreCase(text)){
                return idioma;
            }
        }
        throw new IllegalArgumentException("Idioma no econtrado!!" + text);
    }

    public String getIdiomaGutendex() {
        return idiomaGutendex;
    }

    public String getIdiomaLiteraluraEs() {
        return idiomaLiteraluraEs;
    }

    public String getIdiomaLiteraluraEn() {
        return idiomaLiteraluraEn;
    }
}
