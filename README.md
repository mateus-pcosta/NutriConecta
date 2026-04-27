# NutriConecta

Plataforma web para gerenciamento de doações de alimentos, conectando doadores a instituições que necessitam de assistência alimentar.

## Sobre o projeto

O NutriConecta facilita todo o ciclo de uma doação: desde o cadastro dos alimentos disponíveis até o registro da retirada pela instituição beneficiada. O sistema oferece rastreabilidade completa e um painel com estatísticas de impacto.

## Funcionalidades

### Doador
- Cadastrar doações com título, descrição, quantidade e data de expiração
- Acompanhar o status de cada doação
- Aprovar ou rejeitar solicitações de instituições

### Instituição
- Visualizar doações disponíveis
- Solicitar doações de interesse
- Registrar a retirada após aprovação

### Administrador
- Gerenciar usuários (doadores, instituições)
- Visualizar todas as doações e solicitações

## Fluxo de doação

```
Doador cria doação (ABERTA)
        ↓
Instituição solicita (PENDENTE)
        ↓
Doador aprova → (APROVADA)   |   Doador rejeita → (REJEITADA)
        ↓
Instituição registra retirada
        ↓
Doação concluída (CONCLUIDA)
```

## Tecnologias

- **Java 21**
- **Spring Boot 4**
- **Thymeleaf**
- **Spring Data JPA / Hibernate**
- **MySQL**
- **Bootstrap 5**
- **Lombok**
- **Maven**

## Pré-requisitos

- Java 21+
- MySQL 8+
- Maven (ou usar o `mvnw` incluso no projeto)

## Como rodar localmente

### 1. Clone o repositório

```bash
git clone https://github.com/mateus-pcosta/NutriConecta.git
cd NutriConecta
```

### 2. Configure o banco de dados

Crie o banco no MySQL:

```sql
CREATE DATABASE dbnutriconecta;
```

### 3. Configure as variáveis de ambiente

Copie o arquivo de exemplo e preencha com suas credenciais:

```bash
cp .env.example .env
```

Edite o `.env`:

```env
DB_URL=jdbc:mysql://localhost:3306/dbnutriconecta?useSSL=false&serverTimezone=UTC
DB_USERNAME=seu_usuario
DB_PASSWORD=sua_senha
```

### 4. Exporte as variáveis e rode a aplicação

```bash
export $(cat .env | xargs) && ./mvnw spring-boot:run
```

A aplicação estará disponível em **http://localhost:8080**

## Estrutura do projeto

```
src/
├── main/
│   ├── java/br/com/nutriconecta/
│   │   ├── config/          # Configurações do Spring
│   │   ├── controller/      # Camada de apresentação (rotas HTTP)
│   │   ├── dto/             # Objetos de transferência de dados
│   │   ├── exception/       # Tratamento global de erros
│   │   ├── model/           # Entidades JPA
│   │   │   └── enums/       # Status de doações e solicitações
│   │   ├── repository/      # Acesso ao banco de dados
│   │   ├── security/        # Configurações de segurança
│   │   └── service/         # Regras de negócio
│   └── resources/
│       ├── static/          # CSS, JS e imagens
│       └── templates/       # Páginas HTML (Thymeleaf)
└── test/
```

## Variáveis de ambiente

| Variável      | Descrição                        |
|---------------|----------------------------------|
| `DB_URL`      | URL de conexão com o MySQL       |
| `DB_USERNAME` | Usuário do banco de dados        |
| `DB_PASSWORD` | Senha do banco de dados          |
