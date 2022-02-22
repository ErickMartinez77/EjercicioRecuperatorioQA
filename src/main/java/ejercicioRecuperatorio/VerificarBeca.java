package ejercicioRecuperatorio;

public class VerificarBeca {
    Utils utils;
    public VerificarBeca(Utils utilsMockeado){
        utils = utilsMockeado;
    }
    String msg;
    public String recomendacionBeca(int ci){
        if (Helpers.aplicaBeca(ci)){
            if(utils.getNota(ci)>=90){
                msg = "SI APLICA BECA";
            } else {
                msg = "NO APLICA A BECA POR PROMEDIO ACADEMICO";
            }
        } else {
            msg = "EL ESTUDIANTE NO CURSO AUN EL 60% DE LAS MATERIAS";
        }
        return msg;
    }
}
