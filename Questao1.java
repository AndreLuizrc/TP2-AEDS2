import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

class Lista {

}

class Personagem {
    private String id;
    private String name;
    private Lista alternate_names;
    private String house;
    private String ancestry;
    private String species;
    private String patronus;
    private boolean hogwartsStaff;
    private String hogwatsStudent;
    private String actorName;
    private boolean alive;
    private LocalDate dateOfBirth;
    private int yearOfBith;
    private String eyeColour;
    private String gender;
    private String hairColor;
    private boolean wizard;



    public Personagem(String id, String name, Lista alternate_names, String house, String ancestry, String species,
            String patronus, boolean hogwartsStaff, String hogwatsStudent, String actorName, boolean alive,
            LocalDate dateOfBirth, int yearOfBith, String eyeColour, String gender, String hairColor, boolean wizard) {
        this.id = id;
        this.name = name;
        this.alternate_names = alternate_names;
        this.house = house;
        this.ancestry = ancestry;
        this.species = species;
        this.patronus = patronus;
        this.hogwartsStaff = hogwartsStaff;
        this.hogwatsStudent = hogwatsStudent;
        this.actorName = actorName;
        this.alive = alive;
        this.dateOfBirth = dateOfBirth;
        this.yearOfBith = yearOfBith;
        this.eyeColour = eyeColour;
        this.gender = gender;
        this.hairColor = hairColor;
        this.wizard = wizard;
    }

    public Personagem() {
        this.id = "";
        this.name = "";
        this.alternate_names = [];
        this.house = "";
        this.ancestry = "";
        this.species = "";
        this.patronus = "";
        this.hogwartsStaff = false;
        this.hogwatsStudent = "";
        this.actorName = "";
        this.alive = false;
        this.dateOfBirth = Date.from(null);
        this.yearOfBith = 0;
        this.eyeColour = "";
        this.gender = "";
        this.hairColor = "";
        this.wizard = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lista getAlternate_names() {
        return alternate_names;
    }

    public void setAlternate_names(Lista alternate_names) {
        this.alternate_names = alternate_names;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getAncestry() {
        return ancestry;
    }

    public void setAncestry(String ancestry) {
        this.ancestry = ancestry;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getPatronus() {
        return patronus;
    }

    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }

    public boolean isHogwartsStaff() {
        return hogwartsStaff;
    }

    public void setHogwartsStaff(boolean hogwartsStaff) {
        this.hogwartsStaff = hogwartsStaff;
    }

    public String getHogwatsStudent() {
        return hogwatsStudent;
    }

    public void setHogwatsStudent(String hogwatsStudent) {
        this.hogwatsStudent = hogwatsStudent;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getYearOfBith() {
        return yearOfBith;
    }

    public void setYearOfBith(int yearOfBith) {
        this.yearOfBith = yearOfBith;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public boolean isWizard() {
        return wizard;
    }

    public void setWizard(boolean wizard) {
        this.wizard = wizard;
    }

    public void imprimir(){
        System.out.println("[" + id +"##" + name +"##"+ alternate_names + "##" + house + "##" + ancestry + "##" + species + "##" + patronus + "##" + hogwartsStaff + 
        "##" + hogwatsStudent + "##" + actorName + "##" + alive + "##" + dateOfBirth + "##" + yearOfBith + "##" + eyeColour + "##" + gender + "##" + hairColor + "##" + wizard + "]");
    }

    public Personagem clonar(){
        return this;
    }

    public static String[] ler(String dados){
        String[] atributos = new String[17];
        int tam = dados.length();
        int initialIndex = 0;
        int posicao_vetor = 0;
        for(int i = 0; i < tam; i++){
            if(dados.charAt(i) == ';'){
                atributos[posicao_vetor] = dados.substring(initialIndex, i);
                initialIndex = i+1;
                posicao_vetor++;
            }
        }

        return atributos;
    }

}

public class Questao1 {

    public static void main(String[] args) {
        Personagem[] personagens = new Personagem[405];
        String line;
        String[] atributos;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            Scanner sc = new Scanner(new File("characters.csv"));
            int i = 0;
            while(sc.hasNextLine()){
                line = sc.nextLine();
                atributos = Personagem.ler(line);
                Lista atributo3;
                personagens[i] = new Personagem(atributos[0],atributos[1],atributo3, atributos[3], atributos[4], atributos[5], atributos[6], Boolean.parseBoolean(atributos[7]), atributos[8], atributos[9], 
                Boolean.parseBoolean(atributos[10]),LocalDate.parse(atributos[11], formatter), Integer.parseInt(atributos[12]),atributos[13],atributos[14],atributos[15], Boolean.parseBoolean(atributos[16]));
            }

            sc.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        

    }

}