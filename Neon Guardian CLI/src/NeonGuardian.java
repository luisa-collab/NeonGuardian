import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class NeonGuardian {

    // ==========================================
    // ÁREA DAS CORES NEON (O SEGREDO DO VISUAL)
    // ==========================================
    public static final String RESET = "\033[0m";  // Reseta para a cor padrão
    public static final String RED_NEON = "\033[1;31m"; // Vermelho Brilhante (Perigo/Erro)
    public static final String CYAN_NEON = "\033[1;36m"; // Ciano Brilhante (Sistema/Seguro)
    public static final String PURPLE_NEON = "\033[1;35m"; // Roxo (Títulos/Destaques)
    public static final String BLACK_BG = "\033[40m";    // Fundo Preto

    // Scanner global para ler o que o usuário digita
    static Scanner scanner = new Scanner(System.in);

    // ==========================================
    // O MÉTODO MAIN (ONDE TUDO COMEÇA)
    // ==========================================
    public static void main(String[] args) throws InterruptedException {
        limparTela();
        imprimirBanner();

        boolean sistemaAtivo = true;
        while (sistemaAtivo) {
            mostrarMenuPrincipal();

            System.out.print(CYAN_NEON + "\n[" + RESET + "DIGITE A OPÇÃO DESEJADA" + CYAN_NEON + "]: " + RESET);
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    executarVerificadorSenha();
                    break;
                case "2":
                    executarDetectorPhishing();
                    break;
                case "0":
                    efeitoDigitacao("\n" + RED_NEON + "Deslogando do sistema seguro... Até logo." + RESET, 50);
                    sistemaAtivo = false;
                    break;
                default:
                    System.out.println(RED_NEON + "\n[ERRO] Comando inválido. Tente novamente." + RESET);
            }
        }
    }

    // ==========================================
    // MÉTODOS VISUAIS
    // ==========================================

    public static void imprimirBanner() throws InterruptedException {
        String banner =
                PURPLE_NEON +
                        "  _   _                     ____uardian \n" +
                        " | \\ | | ___  ___  _ __    / ___|_   _  __ _ _ __  _   _  __ _ _ __  \n" +
                        " |  \\| |/ _ \\/ _ \\| '_ \\  | |  _| | | |/ _` | '__|| | | |/ _` | '_ \\ \n" +
                        " | |\\  |  __/ (_) | | | | | |_| | |_| | (_| | |   | |_| | (_| | | | |\n" +
                        " |_| \\_|\\___|\\___/|_| |_|  \\____|\\__,_|\\__,_|_|    \\__, |\\__,_|_| |_|\n" +
                        "                                                   |___/             \n" +
                        RESET + CYAN_NEON + "  >>> SISTEMA DE SEGURANÇA BANCÁRIA - VERSÃO 1.0 <<< \n" + RESET;

        System.out.println(banner);
        animacaoCarregando("INICIALIZANDO MÓDULOS DE SEGURANÇA");
    }

    public static void mostrarMenuPrincipal() {
        System.out.println(CYAN_NEON + "\n==========================================");
        System.out.println("   PAINEL DE CONTROLE PRINCIPAL");
        System.out.println("==========================================" + RESET);
        System.out.println(PURPLE_NEON + "[1]" + RESET + " Análise de Força de Senha");
        System.out.println(PURPLE_NEON + "[2]" + RESET + " Detector de Links Phishing (Em breve)");
        System.out.println(RED_NEON + "[0]" + RESET + " SAIR DO SISTEMA");
        System.out.println(CYAN_NEON + "==========================================" + RESET);
    }

    public static void efeitoDigitacao(String texto, int delayMilissegundos) throws InterruptedException {
        for (char caractere : texto.toCharArray()) {
            System.out.print(caractere);
            TimeUnit.MILLISECONDS.sleep(delayMilissegundos);
        }
        System.out.println();
    }

    public static void animacaoCarregando(String mensagem) throws InterruptedException {
        System.out.print(CYAN_NEON + mensagem + " " + RESET);
        for (int i = 0; i < 5; i++) {
            System.out.print(PURPLE_NEON + "▓" + RESET);
            TimeUnit.MILLISECONDS.sleep(300);
        }
        System.out.println(CYAN_NEON + " [OK]" + RESET);
    }

    public static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    // ==========================================
    // MÉTODOS DE LÓGICA
    // ==========================================

    /**
     * MÉTODO: executarVerificadorSenha (LÓGICA REAL)
     */
    public static void executarVerificadorSenha() throws InterruptedException {
        System.out.println(PURPLE_NEON + "\n--- INICIANDO PROTOCOLO DE ANÁLISE DE SENHA ---" + RESET);

        // 1. Entrada de Dados
        efeitoDigitacao("Digite a senha para teste de força bruta:", 20);
        String senha = scanner.nextLine();

        // Animação de "Thinking"
        System.out.print(CYAN_NEON + "ANALISANDO CRIPTOGRAFIA: " + RESET);
        for (int i = 0; i < 10; i++) {
            System.out.print("█");
            TimeUnit.MILLISECONDS.sleep(100);
        }
        System.out.println();

        // 2. Lógica de Validação
        int score = 0;
        boolean temMaiuscula = false;
        boolean temMinuscula = false;
        boolean temNumero = false;
        boolean temSimbolo = false;

        for (char c : senha.toCharArray()) {
            if (Character.isUpperCase(c)) temMaiuscula = true;
            else if (Character.isLowerCase(c)) temMinuscula = true;
            else if (Character.isDigit(c)) temNumero = true;
            else temSimbolo = true;
        }

        // 3. Cálculo da Pontuação
        if (senha.length() >= 8) score += 20;
        if (temMaiuscula) score += 20;
        if (temMinuscula) score += 20;
        if (temNumero) score += 20;
        if (temSimbolo) score += 20;

        // 4. Exibição do Resultado
        System.out.println("\n-------------------------------------------");

        if (score < 50) {
            System.out.println("NÍVEL DE SEGURANÇA: " + RED_NEON + "CRÍTICO (" + score + "%)" + RESET);
            System.out.println(RED_NEON + "[ALERTA] Essa senha seria quebrada em 0.2 segundos." + RESET);
        } else if (score < 100) {
            System.out.println("NÍVEL DE SEGURANÇA: " + PURPLE_NEON + "MODERADO (" + score + "%)" + RESET);
            System.out.println("Status: Aceitável, mas pode melhorar.");
        } else {
            System.out.println("NÍVEL DE SEGURANÇA: " + CYAN_NEON + "BLINDADO (" + score + "%)" + RESET);
            System.out.println(CYAN_NEON + "[SUCESSO] Senha resistente a ataques de força bruta." + RESET);
        }

        // 5. Feedback
        if (score < 100) {
            System.out.println("\n" + PURPLE_NEON + ">>> RELATÓRIO DE MELHORIA <<<" + RESET);
            if (senha.length() < 8) System.out.println("- Aumente para no mínimo 8 caracteres.");
            if (!temMaiuscula) System.out.println("- Adicione uma letra MAIÚSCULA.");
            if (!temNumero) System.out.println("- Adicione um NÚMERO.");
            if (!temSimbolo) System.out.println("- Adicione um SÍMBOLO (@, #, $).");
        }

        System.out.println("-------------------------------------------\n");
        TimeUnit.SECONDS.sleep(2);
    }
    /**
     * MÉTODO: executarDetectorPhishing
     * O que faz: Analisa URLs em busca de padrões maliciosos comuns em fraudes bancárias.
     */
    public static void executarDetectorPhishing() throws InterruptedException {
        System.out.println(PURPLE_NEON + "\n--- INICIANDO VARREDURA DE URL (PHISHING) ---" + RESET);

        // 1. Entrada de Dados
        efeitoDigitacao("Cole o link suspeito para análise:", 20);
        String url = scanner.nextLine().toLowerCase(); // Converte para minúsculo para facilitar a busca

        // Animação de "Scanning"
        System.out.print(CYAN_NEON + "VARRENDO INTERNET: " + RESET);
        for (int i = 0; i < 15; i++) {
            // Gera caracteres aleatórios para parecer que está "lendo" a rede
            System.out.print((i % 2 == 0) ? "1" : "0");
            TimeUnit.MILLISECONDS.sleep(80);
        }
        System.out.println(" [COMPLETO]");

        // 2. Base de Dados de Ameaças (Arrays de Strings)
        String[] palavrasPerigosas = {"ganhe", "premio", "gratis", "oferta", "urgente", "clique", "bloqueada", "atualize", "promo"};
        String[] dominiosConfiaveis = {"bradesco.com.br", "banco.br", "gov.br", "google.com"};

        int nivelRisco = 0;
        String relatorio = "";

        // 3. A Lógica Forense

        // Checagem A: Protocolo de Segurança (HTTPS)
        if (!url.startsWith("https://")) {
            nivelRisco += 30;
            relatorio += "\n[!] Site NÃO SEGURO (Não usa criptografia HTTPS).";
        }

        // Checagem B: Busca por Palavras-Gatilhho (Engenharia Social)
        for (String palavra : palavrasPerigosas) {
            if (url.contains(palavra)) {
                nivelRisco += 25;
                relatorio += "\n[!] Contém termo de urgência/marketing suspeito: '" + palavra + "'.";
            }
        }

        // Checagem C: Verificação de Domínio (O pulo do gato)
        // Se tem "bradesco" mas NÃO é o site oficial, é GOLPE na certa.
        if (url.contains("bradesco") && !url.contains("bradesco.com.br")) {
            nivelRisco += 100; // Risco Máximo Imediato
            relatorio += "\n[!!!] TENTATIVA DE CLONAGEM DETECTADA (Typosquatting).";
        }

        // 4. Resultado Final
        System.out.println("\n-------------------------------------------");

        if (nivelRisco == 0) {
            System.out.println("STATUS: " + CYAN_NEON + "SEGURO (CLEAN)" + RESET);
            System.out.println("Nenhuma ameaça detectada nos padrões conhecidos.");
        } else if (nivelRisco < 50) {
            System.out.println("STATUS: " + PURPLE_NEON + "SUSPEITO (ATENÇÃO)" + RESET);
            System.out.println("Recomendação: Não insira dados pessoais.");
        } else {
            System.out.println("STATUS: " + RED_NEON + "PERIGO (PHISHING CONFIRMADO)" + RESET);
            System.out.println(RED_NEON + ">>> ACESSO BLOQUEADO PELO GUARDIAN <<<" + RESET);
        }

        // Se houver problemas, mostra o relatório técnico
        if (nivelRisco > 0) {
            System.out.println("\nDETALHES TÉCNICOS:" + RED_NEON + relatorio + RESET);
        }

        System.out.println("-------------------------------------------\n");
        TimeUnit.SECONDS.sleep(3); // Pausa para leitura
    }
}