package variables;

public interface TextLabels {
	
	public String ok = "Weiter";
	public String abbrechen = "Abbrechen";
	public String back = "Zurück";
	
	public String imageOK = "/pics/ok.png";
	public String imageAbbrechen = "/pics/close.png";
	public String imageBack = "/pics/back.png";
	
	public String auftragNeu = "Neuen Auftrag anlegen";
	
	public String[] colheadsKunde = {"Kunden-Nr.", "Vorname", "Name", "Straße", "PLZ", "Ort"};
	public String[] colheadsAuftrag = {"Auftrag-Nr.", "Auftrag-Datum", "Kunden-Name", "Patienten-Name", "Arbeitsart", "Auftrag-Typ", "Versicherung", "Erledigt"};
	public String[] colheadsBenutzer = {"Benutzer-Nr.", "Vorname", "Name", "Berechtigung"};
	public String[] colheadsPatientAuftrag = {"Auftrag-Datum", "Auftrag-Nr.", "Auftrag-Typ", "Kunde", "Kieferbereich", "Arbeitsart", "Zahnfarbe" , "Legierung", "Erledigt"};
	public String[] colheadsMaterial = {"Material-Nr.", "Material-Gruppe", "Hersteller", "Bezeichnung", "Material-Typ", "CE-Zeichen"};
	public String[] colheadsBestandteile = {"Material-Nr.", "Material-Gruppe", "Hersteller", "Bezeichnung", "Material-Typ", "CE-Zeichen", "Charge-Nr"};
	public String[] colheadsAuftragBestandteile = {"Material-Gruppe", "Hersteller", "Bezeichnung", "Material-Typ", "CE-Zeichen", "Charge-Nr"};
	public String[] colheadsSonderwunsch = {"Sonderwunsch"};
	
}
