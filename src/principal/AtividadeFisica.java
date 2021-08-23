package principal;

public class AtividadeFisica {

//    tipo de exercicio-codigo
//    aeróbico:1
//    caminhada:2
//    corrida:3
//    bicicleta:4

    private Integer exercicio;
    private Integer diaDoExercicio;
    private Float distPercorrida;
    private Float tempoExercicio;
    private Float freqCardioMin;
    //private Float freqCardioMax;
    private Float freqCardioAlvo;


    public AtividadeFisica(){}

    public AtividadeFisica(Integer exercicio, Integer diaDoExercicio, Float distPercorrida, Float tempoExercicio, Float freqCardioMin){
        this.exercicio = exercicio;
        this.diaDoExercicio = diaDoExercicio;
        this.distPercorrida = distPercorrida;
        this.tempoExercicio = tempoExercicio;
        this.freqCardioMin = freqCardioMin;
        //this.freqCardioMax = freqCardioMax;
        this.freqCardioAlvo = getFreqCardioAlvo();
    }

    public Integer getExercicio() {
        return exercicio;
    }

    public void setExercicio(Integer exercicio) {
        this.exercicio = exercicio;
    }

    public Integer getDiaDoExercicio() {
        return diaDoExercicio;
    }

    public void setDiaDoExercicio(Integer diaDoExercicio) {
        this.diaDoExercicio = diaDoExercicio;
    }

    public Float getDistPercorrida() {
        return distPercorrida;
    }

    public void setDistPercorrida(Float distPercorrida) {
        this.distPercorrida = distPercorrida;
    }

    public Float getTempoExercicio() {
        return tempoExercicio;
    }

    public void setTempoExercicio(Float tempoExercicio) {
        this.tempoExercicio = tempoExercicio;
    }

    public Float getFreqCardioMin() {
        return freqCardioMin;
    }

    public void setFreqCardioMin(Float freqCardioMin) {
        this.freqCardioMin = freqCardioMin;
    }

    //public Float getFreqCardioMax() {
    //    return freqCardioMax;
    //}

   // public void setFreqCardioMax(Float freqCardioMax) {
   //     this.freqCardioMax = freqCardioMax;
    //}

    public Float getFreqCardioAlvo() {
        return freqCardioAlvo;
    }

    public void setFreqCardioAlvo(Float freqCardioAlvo) {
        this.freqCardioAlvo = freqCardioAlvo;
    }

    public int frequenciaMax(Integer idade){
        return  220 - idade;
    }

}

