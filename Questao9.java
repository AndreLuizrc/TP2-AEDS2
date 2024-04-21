import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Lista {
    private List<String> Lista;

    Lista() {
        this.Lista = new ArrayList<>();
    }

    public List<String> getLista() {
        return Lista;
    }

    public void setLista(List<String> lista) {
        Lista = lista;
    }

    public List<String> parseStringToList(String texto) {
        // Expressão regular para encontrar strings entre aspas simples
        Pattern pattern = Pattern.compile("'(.*?)'");
        Matcher matcher = pattern.matcher(texto);

        // Iterar sobre as correspondências encontradas e adicionar à lista
        while (matcher.find()) {
            Lista.add(matcher.group(1)); // Adiciona o texto capturado entre as aspas simples
        }

        return Lista;

    }
}

class Personagem {
    private String id;
    private String name;
    private List<String> alternate_names;
    private String house;
    private String ancestry;
    private String species;
    private String patronus;
    private boolean hogwartsStaff;
    private boolean hogwatsStudent;
    private String actorName;
    private boolean alive;
    private Date dateOfBirth;
    private int yearOfBith;
    private String eyeColour;
    private String gender;
    private String hairColor;
    private boolean wizard;

    public Personagem(String id, String name, List<String> alternate_names, String house, String ancestry,
            String species,
            String patronus, boolean hogwartsStaff, boolean hogwatsStudent, String actorName, boolean alive,
            Date dateOfBirth, int yearOfBith, String eyeColour, String gender, String hairColor, boolean wizard) {
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
        this.alternate_names = new ArrayList<>();
        this.house = "";
        this.ancestry = "";
        this.species = "";
        this.patronus = "";
        this.hogwartsStaff = false;
        this.hogwatsStudent = false;
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

    public List<String> getAlternate_names() {
        return alternate_names;
    }

    public void setAlternate_names(List<String> alternate_names) {
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

    public boolean getHogwatsStudent() {
        return hogwatsStudent;
    }

    public void setHogwatsStudent(boolean hogwatsStudent) {
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

    public void imprimir() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("[" + id + " ## " + name + " ## "
                + alternate_names.toString().replace('[', '{').replace(']', '}') + " ## " + house + " ## " + ancestry
                + " ## " + species + " ## " + patronus + " ## " + hogwartsStaff +
                " ## " + hogwatsStudent + " ## " + actorName + " ## " + alive + " ## " + formatter.format(dateOfBirth)
                + " ## " + yearOfBith + " ## " + eyeColour + " ## " + gender + " ## " + hairColor + " ## " + wizard
                + "]");
    }

    public Personagem clonar() {
        return this;
    }

    public static String[] ler(String dados) {
        String[] atributos = dados.split(";");

        return atributos;
    }

}

public class Questao9 {

    public static void preencherVetor(Personagem[] personagens, ArrayList<String> ids) {
        String line;
        String[] atributos;
        Lista alternate_names;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date dateOfBirth;
        try {
            Scanner sc = new Scanner(new File("/tmp/characters.csv"));
            int i = 1;
            sc.nextLine();
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                atributos = Personagem.ler(line);
                alternate_names = new Lista();

                for (int j = 0; j < ids.size(); j++) {
                    if (ids.get(j).equals(atributos[0]) == true) {
                        try {
                            dateOfBirth = formatter.parse(atributos[12]);
                            personagens[i] = new Personagem(atributos[0], atributos[1],
                                    alternate_names.parseStringToList(atributos[2]), atributos[3], atributos[4],
                                    atributos[5], atributos[6], atributos[7].equals("VERDADEIRO") ? true : false,
                                    atributos[8].equals("VERDADEIRO") ? true : false, atributos[9],
                                    atributos[10].equals("VERDADEIRO") ? true : false, dateOfBirth,
                                    Integer.parseInt(atributos[13]), atributos[14], atributos[15], atributos[16],
                                    atributos[17].equals("VERDADEIRO") ? true : false);
                            // System.out.println(personagens[i].getId());
                            // System.out.println("Entou no construtor");
                            i++;
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        j = ids.size() + 1;
                    }
                }

            }

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void swap(int i, int j, Personagem[] personagens){
        Personagem tmp = personagens[i];
        personagens[i] = personagens[j];
        personagens[j] = tmp;
    }

    public static void construir(int tam, Personagem[] personagens, int[] comp_mov) {
        for (int i = tam; i > 1 && personagens[i].getHairColor().compareTo(personagens[i / 2].getHairColor()) >= 0; i /= 2) {
            if(personagens[i].getHairColor().compareTo(personagens[i / 2].getHairColor()) == 0){
                if(personagens[i].getName().compareTo(personagens[i / 2].getName()) > 0){
                    comp_mov[0]++;
                    swap(i/2, i, personagens);
                    comp_mov[1] += 3;
                }
            }else{
                comp_mov[0]++;
                swap(i/2, i, personagens);
                comp_mov[1] += 3;
            }
        }
    }

    public static int getMaiorFilho(int i, int tam, Personagem[] personagens) {
        int filho;
        if (2 * i == tam || personagens[2 * i].getHairColor().compareTo(personagens[2 * i + 1].getHairColor()) > 0) {
            filho = 2 * i;
        } else if (personagens[2 * i].getHairColor().compareTo(personagens[2 * i + 1].getHairColor()) == 0) {
            if (personagens[2 * i].getName().compareTo(personagens[2 * i + 1].getName()) > 0) {
                filho = 2 * i;
            } else {
                filho = 2 * i + 1;
            }
        } else {
            filho = 2 * i + 1;
        }

        return filho;
    }

    public static void reconstruir(int tam, Personagem[] personagens, int[] comp_mov) {
        int i = 1;
        while (i <= tam / 2) {
            int filho = getMaiorFilho(i, tam, personagens);
            if (personagens[i].getHairColor().compareTo(personagens[filho].getHairColor()) <= 0) {
                if (personagens[i].getHairColor().compareTo(personagens[filho].getHairColor()) == 0) {
                    if (personagens[i].getName().compareTo(personagens[filho].getName()) < 0) {
                        comp_mov[0] += 3;
                        swap(i, filho, personagens);
                        comp_mov[1] += 3;
                        i = filho;
                    } else {
                        comp_mov[0] += 3;
                        i = tam;
                    }
                } else {
                    comp_mov[0] += 2;
                    swap(i, filho, personagens);
                    comp_mov[1] += 3;
                    i = filho;
                }

            } else {
                comp_mov[0]++;
                i = tam;
            }
        }
    }

    public static void HeapSort(Personagem[] personagens) {
        long inicio = System.nanoTime();
        int[] comp_mov = new int[2];

        for (int tam = 2; tam < personagens.length; tam++) {
            construir(tam, personagens, comp_mov);
        }

        int tam = personagens.length - 1;
        while (tam > 1) {
            swap(1, tam, personagens);
            comp_mov[1] += 3;
            tam--;
            reconstruir(tam, personagens, comp_mov);

        }

        long fim = System.nanoTime();

        long tempoExecucao = fim - inicio;

        log(tempoExecucao, comp_mov);
    }

    public static void log(long tempoExecucao, int[] comp_mov) {
        File log = new File("824007_heapsort.txt");
        double segundos = tempoExecucao / 1_000_000_000.0;

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(log, true));
            writer.println("824007\t" + comp_mov[0] + "\t" + comp_mov[1] + "\t" + segundos);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ids = new ArrayList<>();
        String id;

        id = sc.nextLine();
        while (id.equals("FIM") != true) {
            ids.add(id);
            // System.out.println("Valor lido: " + ids[i]);
            id = sc.nextLine();
        }

        Personagem[] personagens = new Personagem[ids.size() + 1];

        // System.out.println(personagens.length);
        preencherVetor(personagens, ids);

        HeapSort(personagens);

        for (int i = 1; i < personagens.length; i++) {
            personagens[i].imprimir();
        }

        sc.close();
    }

}
