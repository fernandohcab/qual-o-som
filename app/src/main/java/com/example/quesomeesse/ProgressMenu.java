package com.example.quesomeesse;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class ProgressMenu extends AppCompatActivity {

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Set the activity fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        // Go back to main menu
        ImageView backButton = findViewById(R.id.backButtonProgress);
        backButton.setOnClickListener(v -> finish());

        prefs = getSharedPreferences("data", MODE_PRIVATE);

    }

    @Override
    public void onResume(){
        super.onResume();

        // Create the levels
        ArrayList<Answers> answers = new ArrayList<>();
        if(Locale.getDefault().getDisplayLanguage().toLowerCase().equals("português")) {
            answers.add(new Answers(1, "lata de refrigerante", R.raw.lata, prefs.getInt("1", 0), "garrafa", "algum pote", "desodorante"));
            answers.add(new Answers(2, "carro", R.raw.carengine, prefs.getInt("2", 0),"barco", "avião", "trator"));
            answers.add(new Answers(3, "cachorro", R.raw.dog, prefs.getInt("3", 0),"cachoro", "gritos", "gatos"));
            answers.add(new Answers(4, "cortar papel", R.raw.cutpaper, prefs.getInt("4", 0),"arranhar algo", "apontador de lápis", "escrever"));
            answers.add(new Answers(5, "disparo", R.raw.gunshot, prefs.getInt("5", 0),"explosão", "chaves", "porta"));
            answers.add(new Answers(6, "fechar a porta", R.raw.closedoor, prefs.getInt("6", 0),"bilhar", "bater à porta", "derrubar algo"));
            answers.add(new Answers(7, "vaca", R.raw.cow, prefs.getInt("7", 0),"vaiar", "buzina", "grito"));
            answers.add(new Answers(8, "violão", R.raw.guitar, prefs.getInt("8", 0),"flauta", "violino", "harpa"));
            answers.add(new Answers(9, "maçã", R.raw.apple, prefs.getInt("9", 0),"quebrar algo", "esmagar", "embalagem"));
            answers.add(new Answers(10, "aerosol", R.raw.aerosol, prefs.getInt("10", 0),"soprar", "inseto", "chantilly"));
            answers.add(new Answers(11, "escovar os dentes", R.raw.brushingteeth, prefs.getInt("11", 0),"sacudir algo", "tique-taque", "barbear"));
            answers.add(new Answers(12, "micro-ondas", R.raw.microwave, prefs.getInt("12", 0),"lava-louças", "avião", "forno"));
            answers.add(new Answers(13, "abrir a porta", R.raw.openingdoor, prefs.getInt("13", 0),"apitar", "baleia", "arrastar algo"));
            answers.add(new Answers(14, "apontador de lápis", R.raw.pencilsharpening, prefs.getInt("14", 0),"mastigar", "crocante", "moer algo"));
            answers.add(new Answers(15, "colocar cinto de segurança", R.raw.seatbeltairplane, prefs.getInt("15", 0),"telefone tocando", "piano", "metrô"));
            answers.add(new Answers(16, "elefante", R.raw.elephant, prefs.getInt("16", 0),"bexiga", "hipopótamo", "rinoceronte"));
            answers.add(new Answers(17, "discar", R.raw.phonedial, prefs.getInt("17", 0),"robô", "alarme", "gaita"));
            answers.add(new Answers(18, "explosão", R.raw.explosion, prefs.getInt("18", 0),"avião", "vazamento de água", "disparo"));
            answers.add(new Answers(19, "liquidificador", R.raw.blender, prefs.getInt("19", 0),"furadeira", "cachorro", "batedeira"));
            answers.add(new Answers(20, "apagar lousa", R.raw.erasingchalkboard, prefs.getInt("20", 0),"escrever em papel", "mousepad", "borracha"));
            answers.add(new Answers(21, "gato", R.raw.cat, prefs.getInt("21", 0),"criança", "onça", "águia"));
            answers.add(new Answers(22, "vidro quebrado", R.raw.glass, prefs.getInt("22", 0),"raio", "brindar", "fotografar"));
            answers.add(new Answers(23, "mosquito", R.raw.mosquito, prefs.getInt("23", 0),"geladeira", "borboleta", "drone"));
            answers.add(new Answers(24, "ping-pong", R.raw.pingpong, prefs.getInt("24", 0),"tique-taque", "peteca", "basquete"));
            answers.add(new Answers(25, "avião", R.raw.airplanelanding, prefs.getInt("25", 0),"ventilador", "trem", "fábrica"));
            answers.add(new Answers(26, "pipoca", R.raw.popcorn, prefs.getInt("26", 0),"chuva", "bombas", "rio"));
            answers.add(new Answers(27, "espirro", R.raw.sneeze, prefs.getInt("27", 0),"grito", "tossir", "cachorro"));
            answers.add(new Answers(28, "folhear um livro", R.raw.flipthrough, prefs.getInt("28", 0),"recortar papel", "abanar", "assoprar"));
            answers.add(new Answers(29, "bater à porta", R.raw.knockingdoor, prefs.getInt("29", 0),"tambor", "sapateado", "tablado"));
            answers.add(new Answers(30, "galinha", R.raw.chicken, prefs.getInt("30", 0),"gato", "pombo", "morcego"));
            answers.add(new Answers(31, "rasgar papel", R.raw.rasgarpapel, prefs.getInt("31", 0),"velcro", "rasgar tecido", "amassar papel"));
            answers.add(new Answers(32, "brindar", R.raw.toasting, prefs.getInt("32", 0),"sino de igreja", "piano", "pássaro"));
            answers.add(new Answers(33, "broca de dentista", R.raw.dentistdrill, prefs.getInt("33", 0),"alarme", "apito", "vazamento de gás"));
            answers.add(new Answers(34, "fritura", R.raw.frying, prefs.getInt("34", 0),"chuva", "água fervendo", "rio"));
            answers.add(new Answers(35, "cavalo", R.raw.horserunning, prefs.getInt("35", 0),"trem", "martelo", "bater à porta"));
            answers.add(new Answers(36, "alarme", R.raw.alarm, prefs.getInt("36", 0),"chaves", "telefone", "campainha"));
            answers.add(new Answers(37, "zíper", R.raw.ziper, prefs.getInt("37", 0),"velcro", "ronronar", "porta de correr"));
            answers.add(new Answers(38, "teclado de computador", R.raw.pckeyboard, prefs.getInt("38", 0),"máquina de escrever", "telégrafo", "passos"));
            answers.add(new Answers(39, "bola de bilhar", R.raw.poolball, prefs.getInt("39", 0),"pebolim", "dominó", "brindar"));
            answers.add(new Answers(40, "grampeador", R.raw.stapler, prefs.getInt("40", 0),"pistola de grampos", "tirar foto", "tambor"));
            answers.add(new Answers(41, "impressora", R.raw.printer, prefs.getInt("41", 0),"caixa eletrônico", "esteira", "furadeira"));
            answers.add(new Answers(42, "bebê cjorando", R.raw.babycrying, prefs.getInt("42", 0),"bezerro", "risada", "engasgar"));
            answers.add(new Answers(43, "telefone tocando", R.raw.telephoneringing, prefs.getInt("43", 0),"campainha", "teclado musical", "sirene"));
            answers.add(new Answers(44, "buzina", R.raw.carhorn, prefs.getInt("44", 0),"trem", "bicicleta", "caminhão"));
            answers.add(new Answers(45, "mouse de computador", R.raw.mouseclicking, prefs.getInt("45", 0),"grampeador", "carimbo", "pipoca"));
            answers.add(new Answers(46, "câmera fotográfica", R.raw.camera, prefs.getInt("46", 0),"impressora", "fax", "máquina de costura"));
            answers.add(new Answers(47, "patos", R.raw.ducks, prefs.getInt("47", 0),"buzina", "gaivota", "madeira rangendo"));
            answers.add(new Answers(48, "cabra", R.raw.goat, prefs.getInt("48", 0),"ovelha", "bebê", "motor"));
            answers.add(new Answers(49, "sirene", R.raw.siren, prefs.getInt("49", 0),"trompete", "gritos", "gato"));
            answers.add(new Answers(50, "escrever na lousa", R.raw.chalkboardwritting, prefs.getInt("50", 0),"escovar os dentes", "graffiti", "skate"));
            answers.add(new Answers(51, "caixa eletrônico", R.raw.atm, prefs.getInt("51", 0),"liquidificador", "motocicleta", "triturador de alimentos"));
            answers.add(new Answers(52, "cobra", R.raw.snake, prefs.getInt("52", 0),"panela de pressão", "spray", "garrafa de refrigerante"));
            answers.add(new Answers(53, "tique-taque", R.raw.clockticking, prefs.getInt("53", 0),"limpador de parabrisas", "máquina de escrever", "telégrafo"));
            answers.add(new Answers(54, "piano", R.raw.piano, prefs.getInt("54", 0),"violão", "baixo", "harpa"));
            answers.add(new Answers(55, "pássaros", R.raw.birds, prefs.getInt("55", 0),"galinha", "sino", "avestruz"));
            answers.add(new Answers(56, "buzina de barco", R.raw.boathorn, prefs.getInt("56", 0), "arrastar cadeira", "vaca", "berrante"));
            answers.add(new Answers(57, "comida crocante", R.raw.chewfood, prefs.getInt("57", 0), "chiclete", "isopor", "galhos de árvore"));
        }

        else if(Locale.getDefault().getDisplayLanguage().toLowerCase().equals("english")){
            answers.add(new Answers(1, "can of soda", R.raw.lata, prefs.getInt("1", 0),"bottle", "some pot", "deodorant"));
            answers.add(new Answers(2, "car", R.raw.carengine, prefs.getInt("2", 0),"boat", "airplane", "tractor"));
            answers.add(new Answers(3, "dog", R.raw.dog, prefs.getInt("3", 0),"doug", "screams", "cats"));
            answers.add(new Answers(4, "cut paper", R.raw.cutpaper, prefs.getInt("4", 0),"scratch something", "pencil sharpener", "writing"));
            answers.add(new Answers(5, "gun shot", R.raw.gunshot, prefs.getInt("5", 0),"explosion", "keys", "door"));
            answers.add(new Answers(6, "close the door", R.raw.closedoor, prefs.getInt("6", 0),"pool", "knock the door", "drop something"));
            answers.add(new Answers(7, "cow", R.raw.cow, prefs.getInt("7", 0),"boo", "horn", "scream"));
            answers.add(new Answers(8, "guitar", R.raw.guitar, prefs.getInt("8", 0),"flute", "violin", "harp"));
            answers.add(new Answers(9, "apple", R.raw.apple, prefs.getInt("9", 0),"break something", "smash", "packing"));
            answers.add(new Answers(10, "aerosol", R.raw.aerosol, prefs.getInt("10", 0),"blow", "bug", "chantilly"));
            answers.add(new Answers(11, "brushing teeth", R.raw.brushingteeth, prefs.getInt("11", 0),"shake something", "ticking", "to shave"));
            answers.add(new Answers(12, "microwave", R.raw.microwave, prefs.getInt("12", 0),"dishwasher", "airplane", "oven"));
            answers.add(new Answers(13, "open the door", R.raw.openingdoor, prefs.getInt("13", 0),"whistle", "whale", "drag something"));
            answers.add(new Answers(14, "pencil sharpener", R.raw.pencilsharpening, prefs.getInt("14", 0),"chew", "crunchy", "grind something"));
            answers.add(new Answers(15, "fasten your seat belt", R.raw.seatbeltairplane, prefs.getInt("15", 0),"telephone ringing", "piano", "subway"));
            answers.add(new Answers(16, "elephant", R.raw.elephant, prefs.getInt("16", 0),"bladder", "hipoppotamus", "rhinoceros"));
            answers.add(new Answers(17, "dial", R.raw.phonedial, prefs.getInt("17", 0),"robot", "alarm", "harmonica"));
            answers.add(new Answers(18, "explosion", R.raw.explosion, prefs.getInt("18", 0),"airplane", "water leak", "gun shot"));
            answers.add(new Answers(19, "blender", R.raw.blender, prefs.getInt("19", 0),"drilling machine", "dog", "food mixer"));
            answers.add(new Answers(20, "erase chalkboard", R.raw.erasingchalkboard, prefs.getInt("20", 0),"write on paper", "mousepad", "eraser"));
            answers.add(new Answers(21, "cat", R.raw.cat, prefs.getInt("21", 0),"child", "jaguar", "eagle"));
            answers.add(new Answers(22, "glass", R.raw.glass, prefs.getInt("22", 0),"lightining", "to toast", "take a photo"));
            answers.add(new Answers(23, "mosquito", R.raw.mosquito, prefs.getInt("23", 0),"refrigerator", "butterfly", "drone"));
            answers.add(new Answers(24, "ping pong", R.raw.pingpong, prefs.getInt("24", 0),"ticking", "shuttlecock", "basketball"));
            answers.add(new Answers(25, "airplane", R.raw.airplanelanding, prefs.getInt("25", 0),"fan", "train", "factory"));
            answers.add(new Answers(26, "popcorn", R.raw.popcorn, prefs.getInt("26", 0),"rain", "bombs", "river"));
            answers.add(new Answers(27, "sneeze", R.raw.sneeze, prefs.getInt("27", 0),"scream", "to cough", "dog"));
            answers.add(new Answers(28, "flip through a book", R.raw.flipthrough, prefs.getInt("28", 0),"cut paper", "wag", "blow"));
            answers.add(new Answers(29, "knock the door", R.raw.knockingdoor, prefs.getInt("29", 0),"drum", "tap dance", "platform"));
            answers.add(new Answers(30, "chicken", R.raw.chicken, prefs.getInt("30", 0),"cat", "pigeon", "bat"));
            answers.add(new Answers(31, "rip paper", R.raw.rasgarpapel, prefs.getInt("31", 0),"velcro", "tear a fabric", "kneading paper"));
            answers.add(new Answers(32, "to toast", R.raw.toasting, prefs.getInt("32", 0),"church bell", "piano", "bird"));
            answers.add(new Answers(33, "dentist drill", R.raw.dentistdrill, prefs.getInt("33", 0),"alarm", "whistle", "gas leak"));
            answers.add(new Answers(34, "frying", R.raw.frying, prefs.getInt("34", 0),"rain", "boiling water", "river"));
            answers.add(new Answers(35, "horse", R.raw.horserunning, prefs.getInt("35", 0),"train", "hammer", "knock the door"));
            answers.add(new Answers(36, "alarm", R.raw.alarm, prefs.getInt("36", 0),"keys", "telephone", "bell"));
            answers.add(new Answers(37, "ziper", R.raw.ziper, prefs.getInt("37", 0),"velcro", "purr", "sliding door"));
            answers.add(new Answers(38, "computer keyboard", R.raw.pckeyboard, prefs.getInt("38", 0),"typewriter", "telegraph", "footsteps"));
            answers.add(new Answers(39, "pool ball", R.raw.poolball, prefs.getInt("39", 0),"foosball", "domino", "to toast"));
            answers.add(new Answers(40, "stapler", R.raw.stapler, prefs.getInt("40", 0),"staple gun", "take a photo", "drum"));
            answers.add(new Answers(41, "printer", R.raw.printer, prefs.getInt("41", 0),"ATM", "running machine", "drilling machine"));
            answers.add(new Answers(42, "baby crying", R.raw.babycrying, prefs.getInt("42", 0),"calf", "laugh", "choke"));
            answers.add(new Answers(43, "telephone ringing", R.raw.telephoneringing, prefs.getInt("43", 0),"bell", "musical keyboard", "siren"));
            answers.add(new Answers(44, "horn", R.raw.carhorn, prefs.getInt("44", 0),"train", "bicycle", "truck"));
            answers.add(new Answers(45, "computer mouse", R.raw.mouseclicking, prefs.getInt("45", 0),"stapler", "stamp", "popcorn"));
            answers.add(new Answers(46, "photografic camera", R.raw.camera, prefs.getInt("46", 0),"printer", "fax", "sewing machine"));
            answers.add(new Answers(47, "ducks", R.raw.ducks, prefs.getInt("47", 0),"horn", "seagull", "creaking wood"));
            answers.add(new Answers(48, "goat", R.raw.goat, prefs.getInt("48", 0),"sheep", "baby", "engine"));
            answers.add(new Answers(49, "siren", R.raw.siren, prefs.getInt("49", 0),"trumpet", "screams", "cat"));
            answers.add(new Answers(50, "write on the blackboard", R.raw.chalkboardwritting, prefs.getInt("50", 0),"brushing teeth", "graffiti", "skate"));
            answers.add(new Answers(51, "ATM", R.raw.atm, prefs.getInt("51", 0),"blender", "motorcycle", "food crushing machine"));
            answers.add(new Answers(52, "snake", R.raw.snake, prefs.getInt("52", 0),"pressure cooker", "spray", "soda bottle"));
            answers.add(new Answers(53, "ticking", R.raw.clockticking, prefs.getInt("53", 0),"windshield wiper", "typewriter", "telegraph"));
            answers.add(new Answers(54, "piano", R.raw.piano, prefs.getInt("54", 0),"guitar", "bass", "harp"));
            answers.add(new Answers(55, "birds", R.raw.birds, prefs.getInt("55", 0),"chicken", "bell", "ostrich"));
            answers.add(new Answers(56, "boat horn", R.raw.boathorn, prefs.getInt("56", 0), "drag chair", "cow", "gaudy"));
            answers.add(new Answers(57, "crispy food", R.raw.chewfood, prefs.getInt("57", 0), "bubble gum", "styrofoam", "tree branches"));
        }

        else if(Locale.getDefault().getDisplayLanguage().toLowerCase().equals("español")){
            answers.add(new Answers(1, "lata de gaseosa", R.raw.lata, prefs.getInt("1", 0),"botella", "algún tarro", "desodorante"));
            answers.add(new Answers(2, "coche", R.raw.carengine, prefs.getInt("2", 0),"bote", "avión", "tractor"));
            answers.add(new Answers(3, "perro", R.raw.dog, prefs.getInt("3", 0),"peros", "gritos", "gatos"));
            answers.add(new Answers(4, "cortar papel", R.raw.cutpaper, prefs.getInt("4", 0),"rascar algo", "apuntador de lápiz", "escribir"));
            answers.add(new Answers(5, "disparo", R.raw.gunshot, prefs.getInt("5", 0),"explosión", "llaves", "puerta"));
            answers.add(new Answers(6, "cerrar la puerta", R.raw.closedoor, prefs.getInt("6", 0),"billar", "tocar la puerta", "soltar algo"));
            answers.add(new Answers(7, "vaca", R.raw.cow, prefs.getInt("7", 0),"abucheo", "bocina", "grito"));
            answers.add(new Answers(8, "guitarra", R.raw.guitar, prefs.getInt("8", 0),"flauta", "violín", "arpa"));
            answers.add(new Answers(9, "manzana", R.raw.apple, prefs.getInt("9", 0),"romper algo", "aplastar", "embalaje"));
            answers.add(new Answers(10, "aerosol", R.raw.aerosol, prefs.getInt("10", 0),"soplar", "insecto", "chantilly"));
            answers.add(new Answers(11, "cepillarse los dientes", R.raw.brushingteeth, prefs.getInt("11", 0),"sacudir algo", "tictac", "afeitar"));
            answers.add(new Answers(12, "microondas", R.raw.microwave, prefs.getInt("12", 0),"lava platos", "avión", "horno"));
            answers.add(new Answers(13, "abrir la puerta", R.raw.openingdoor, prefs.getInt("13", 0),"silbar", "ballena", "arrastar algo"));
            answers.add(new Answers(14, "apuntador de lápiz", R.raw.pencilsharpening, prefs.getInt("14", 0),"masticar", "crujiente", "moler algo"));
            answers.add(new Answers(15, "abrochar el cinturón de seguridad", R.raw.seatbeltairplane, prefs.getInt("15", 0),"teléfono sonando", "piano", "subterraneo"));
            answers.add(new Answers(16, "elefante", R.raw.elephant, prefs.getInt("16", 0),"vejiga", "hipopótamo", "rinoceronte"));
            answers.add(new Answers(17, "marcar en el teléfono", R.raw.phonedial, prefs.getInt("17", 0),"robot", "alarma", "harmónica"));
            answers.add(new Answers(18, "explosión", R.raw.explosion, prefs.getInt("18", 0),"avión", "gotera de agua", "disparo"));
            answers.add(new Answers(19, "licuadora", R.raw.blender, prefs.getInt("19", 0),"taladro", "perro", "procesador de alimentos"));
            answers.add(new Answers(20, "borra pizarra", R.raw.erasingchalkboard, prefs.getInt("20", 0),"escribir en papel", "alfombrilla de ratón", "borrador"));
            answers.add(new Answers(21, "gato", R.raw.cat, prefs.getInt("21", 0),"niño", "jaguar", "águila"));
            answers.add(new Answers(22, "vidrio roto", R.raw.glass, prefs.getInt("22", 0),"relámpago", "brindis", "sacar una foto"));
            answers.add(new Answers(23, "mosquito", R.raw.mosquito, prefs.getInt("23", 0),"refrigerador", "mariposa", "drone"));
            answers.add(new Answers(24, "ping pong", R.raw.pingpong, prefs.getInt("24", 0),"tic tac", "volante", "baloncesto"));
            answers.add(new Answers(25, "avión", R.raw.airplanelanding, prefs.getInt("25", 0),"ventilador", "tren", "fábrica"));
            answers.add(new Answers(26, "palomita", R.raw.popcorn, prefs.getInt("26", 0),"lluvia", "bombas", "río"));
            answers.add(new Answers(27, "estornudo", R.raw.sneeze, prefs.getInt("27", 0),"grito", "toser", "perro"));
            answers.add(new Answers(28, "hojear un libro", R.raw.flipthrough, prefs.getInt("28", 0),"cortar papel", "sacudir", "soplar"));
            answers.add(new Answers(29, "tocar la puerta", R.raw.knockingdoor, prefs.getInt("29", 0),"tambor", "zapateado", "plataforma"));
            answers.add(new Answers(30, "pollo", R.raw.chicken, prefs.getInt("30", 0),"gato", "paloma", "murciélago"));
            answers.add(new Answers(31, "papel rasgado", R.raw.rasgarpapel, prefs.getInt("31", 0),"velcro", "rasgar la tela", "arrugar papel"));
            answers.add(new Answers(32, "brindis", R.raw.toasting, prefs.getInt("32", 0),"campana de iglesia", "piano", "ave"));
            answers.add(new Answers(33, "taladro de dentista", R.raw.dentistdrill, prefs.getInt("33", 0),"alarma", "silbar", "fuga de gas"));
            answers.add(new Answers(34, "fritura", R.raw.frying, prefs.getInt("34", 0),"lluvia", "agua hirviendo", "río"));
            answers.add(new Answers(35, "caballo", R.raw.horserunning, prefs.getInt("35", 0),"tren", "martillo", "tocar la puerta"));
            answers.add(new Answers(36, "alarma", R.raw.alarm, prefs.getInt("36", 0),"llaves", "teléfono", "timbre de la puerta"));
            answers.add(new Answers(37, "cremallera", R.raw.ziper, prefs.getInt("37", 0),"velcro", "ronroneo", "puerta corrediza"));
            answers.add(new Answers(38, "teclado de computadora", R.raw.pckeyboard, prefs.getInt("38", 0),"maquina de escribir", "telégrafo", "pasos"));
            answers.add(new Answers(39, "bola de billar", R.raw.poolball, prefs.getInt("39", 0),"futbolín", "dominó", "brindis"));
            answers.add(new Answers(40, "engrapadora", R.raw.stapler, prefs.getInt("40", 0),"grapadora", "sacar una foto", "tambor"));
            answers.add(new Answers(41, "impresora", R.raw.printer, prefs.getInt("41", 0),"cajero automático", "rueda de andar", "taladro"));
            answers.add(new Answers(42, "llanto de bebé", R.raw.babycrying, prefs.getInt("42", 0),"becerro", "risa", "ahogo"));
            answers.add(new Answers(43, "teléfono sonando", R.raw.telephoneringing, prefs.getInt("43", 0),"timbre", "teclado musical", "sirena"));
            answers.add(new Answers(44, "bocina", R.raw.carhorn, prefs.getInt("44", 0),"tren", "bicicleta", "camión"));
            answers.add(new Answers(45, "ratón de computadora", R.raw.mouseclicking, prefs.getInt("45", 0),"engrapadora", "sello", "palomita"));
            answers.add(new Answers(46, "cámara fotográfica", R.raw.camera, prefs.getInt("46", 0),"impresora", "fax", "máquina de coser"));
            answers.add(new Answers(47, "patos", R.raw.ducks, prefs.getInt("47", 0),"bocina", "gaviota", "madera al azar"));
            answers.add(new Answers(48, "cabra", R.raw.goat, prefs.getInt("48", 0),"oveja", "bebé", "motor"));
            answers.add(new Answers(49, "sirena", R.raw.siren, prefs.getInt("49", 0),"trompeta", "gritos", "gato"));
            answers.add(new Answers(50, "escribir en la pizarra", R.raw.chalkboardwritting, prefs.getInt("50", 0),"cepillarse los dientes", "graffiti", "patineta"));
            answers.add(new Answers(51, "cajero automático", R.raw.atm, prefs.getInt("51", 0),"licuadora", "motocicleta", "triturador de alimentos"));
            answers.add(new Answers(52, "serpiente", R.raw.snake, prefs.getInt("52", 0),"olla a presión", "spray", "botella de soda"));
            answers.add(new Answers(53, "tictac", R.raw.clockticking, prefs.getInt("53", 0),"limpiaparabrisas", "maquina de escribir", "telégrafo"));
            answers.add(new Answers(54, "piano", R.raw.piano, prefs.getInt("54", 0),"guitarra", "el bajo", "arpa"));
            answers.add(new Answers(55, "aves", R.raw.birds, prefs.getInt("55", 0),"pollo", "campana", "avestruz"));
            answers.add(new Answers(56, "bocina de barco", R.raw.boathorn, prefs.getInt("56", 0), "arrastra la silla", "vaca", "llamativos"));
            answers.add(new Answers(57, "comida crujiente", R.raw.chewfood, prefs.getInt("57", 0), "chicle", "espuma de poliestireno", "ramas de los árboles"));
        }
        AnswersAdapter adapter = new AnswersAdapter(this, answers);

        // Show the levels in GridView
        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(adapter);

    }

}