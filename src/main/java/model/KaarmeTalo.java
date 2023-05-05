package model;

public class KaarmeTalo {

	 private String nimi;
	    private int ika;
	    private int paino;

	    /**
	     * Empty constructor only used by Gson when converting JSON Strings to Java
	     * objects. Set to private to prevent creating uninitialized objects.
	     */
	    @SuppressWarnings("unused")
		public KaarmeTalo() {
	    }

	    public KaarmeTalo(String nimi, int ika, int paino) {
	        this.nimi = nimi;
	        this.ika = ika;
	        this.paino = paino;
	    }

	    public String getNimi() {
	        return nimi;
	    }

	    public void setNimi(String nimi) {
	        this.nimi = nimi;
	    }

	    public int getIka() {
	        return ika;
	    }
	    
	    public void setIka(int ika) {
	        this.ika = ika;
	    }
	    
	    public int getPaino() {
	        return paino;
	    }
	    
	    public void setpaino(int paino) {
	        this.paino = paino;
	    }

	    @Override
	    public boolean equals(Object other) {
	        return other instanceof KaarmeTalo && ((KaarmeTalo) other).nimi == this.nimi;
	    }
	}
