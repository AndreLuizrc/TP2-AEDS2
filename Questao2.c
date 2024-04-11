#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>
#include <stdlib.h>

typedef struct {
    char Lista[500];
}Lista;

typedef struct {
    char id[200];
    char name[200];
    Lista alternate_names;
    char house[200];
    char ancestry[200];
    char species[200];
    char patronus[200];
    bool hogwartsStaff;
    char hogwartsStudent[200];
    char actorName[200];
    bool alive;
    time_t dateOfBirth;
    int yearOfBith;
    char eyeColour[200];
    char gender[200];
    char hairColor[200];
    bool wizard;
    
}Personagem;

Personagem construtor(char*, char*, char*, char*, char*, char*, char*, bool, char*, char*, bool, time_t,
int, char*, char*, char*, bool);

char* getId(Personagem*);

Personagem setId(char*);

void imprimir(Personagem*);

char **ler(char*);

void PreencherVetor(Personagem*);


int main(){
    char id[200];
    Personagem personagens[405];
    PreencherVetor(personagens);

    fgets(id,200,stdin);
    while(strcmp(id, "FIM") != 0){
        for(int i = 0; i < 405; i++){
            if(strcmp(personagens[i].id,id) == 0){
                imprimir(&personagens[i]);
                i = 500;
            }
        }
        fgets(id,200,stdin);
    }
}

Personagem construtor(char id[], char name[], char alternate_names[], char house[], char ancestry[], char species[], char patronus[], bool hogwartsStaff, char hogwartsStudent[], char actorName[], bool alive, time_t dateOfBirth,
int yerOfBirth, char eyeColour[], char gender[], char hairColor[], bool wizard){
    Personagem P;

    strcpy(P.id, id);
    strcpy(P.name, name);
    strcpy(P.alternate_names.Lista, alternate_names);
    strcpy(P.house, house);
    strcpy(P.ancestry, ancestry);
    strcpy(P.patronus, patronus);
    P.hogwartsStaff = hogwartsStaff;
    strcpy(P.hogwartsStudent, hogwartsStudent);
    strcpy(P.actorName, actorName);
    P.alive = alive;
    P.dateOfBirth = dateOfBirth;
    P.yearOfBith = 10;
    strcpy(P.eyeColour, eyeColour);
    strcpy(P.gender, gender);
    strcpy(P.hairColor, hairColor);
    P.wizard = wizard;

    return P;
}

char **ler(char line[]){
    char **tokens = malloc(18 * sizeof(char *));
    char *separador = ";";

    int num_tokens = 0;
    char *token = strtok(line, separador); // Obtém o primeiro token
    while (token != NULL && num_tokens < 18) {
        tokens[num_tokens++] = token; // Armazena o token no array de tokens
        token = strtok(NULL, separador); // Obtém o próximo token
    }

    return tokens;
}

void imprimir(Personagem *P){
    printf("[ %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s]",
     P->id, P->name, P->alternate_names.Lista, P->house, P->ancestry, P->species, P->patronus,
     P->hogwartsStaff);
}

void PreencherVetor(Personagem personagens[]){
    FILE *arquivo_csv;
    char line[400];
    struct tm data;
    if((arquivo_csv = fopen("characters.csv", "r")) != NULL){
        int i = 0;
        while( fgets(line,400,arquivo_csv) != NULL){
            char **atributos = ler(line);
            sscanf(atributos[12], "%d-%d-%d", &data.tm_mday, &data.tm_mon, &data.tm_year);
            time_t dateOfBirth = mktime(&data);
            personagens[i] = construtor(atributos[0],atributos[1],atributos[2],atributos[3],atributos[4],
            atributos[5], atributos[6], strcmp(atributos[7], "VERDADEIRO") == 0? true: false, atributos[8], atributos[9], atributos[10],
            dateOfBirth,atoi(atributos[13]), atributos[14], atributos[15], atributos[16], strcmp(atributos[17], "VERDADEIRO") == 0? true: false);
            free(atributos);
        }
    }
    
}