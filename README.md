# 🛡️ Neon Guardian CLI

> Simulador de Ferramentas de Cibersegurança Bancária em Java.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Security](https://img.shields.io/badge/Security-Hacking-red?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Finished-success?style=for-the-badge)

## 💻 Sobre o Projeto
O **Neon Guardian** é uma aplicação de linha de comando (CLI) desenvolvida para simular rotinas de segurança da informação. O projeto foca em lógica de programação, manipulação de Strings e experiência do usuário (UX) através de interfaces de terminal estilizadas com ANSI Art.

O objetivo foi criar uma ferramenta que analisasse vulnerabilidades em tempo real.

## 🚀 Funcionalidades

### 1. Verificador de Entropia de Senhas
Analisa a força de uma senha baseada em critérios de segurança bancária:
- [x] Comprimento mínimo (8 chars)
- [x] Presença de Maiúsculas/Minúsculas
- [x] Números e Símbolos
- **Retorno:** Classificação visual (Crítico, Moderado, Blindado) e feedback de melhoria.

### 2. Detector de Phishing (Anti-Fraude)
Analisa URLs suspeitas buscando padrões de golpes comuns:
- [x] Verificação de protocolo HTTPS
- [x] Detecção de palavras de engenharia social ("ganhe", "urgente")
- [x] Identificação de Typosquatting (ex: domínios falsos imitando bancos)

## 🛠️ Tecnologias Utilizadas
- **Java (JDK 17+)**
- **Lógica:** Estruturas condicionais, Loops, Manipulação de Strings e Regex.
- **Design:** Códigos de escape ANSI para coloração de terminal e animações de delay.

## 📸 Screenshots
*(Coloque aqui um print do seu terminal rodando o programa)*

---
Desenvolvido por [Seu Nome] 👩‍💻
