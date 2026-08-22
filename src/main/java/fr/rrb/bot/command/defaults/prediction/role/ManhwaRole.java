package fr.rrb.bot.command.defaults.prediction.role;

public enum ManhwaRole implements Role {
  // Héros
  ARTHUR(
      "Arthur", "Héros", "https://wd40.theking90000.be/files/53a95aa1-4ef2-482e-8842-b213c1c4b5a0"),
  KANA("Kana", "Héros", "https://wd40.theking90000.be/files/7fbd538c-c00f-4029-9dfd-ea7eb70e4d37"),
  YU_IJIN(
      "Yu Ijin",
      "Héros",
      "https://wd40.theking90000.be/files/dab1458a-7f9e-46a4-a955-fdeba9028163"),
  DOKJA(
      "Dokja", "Héros", "https://wd40.theking90000.be/files/15dd69e9-60e8-4d3b-82e4-cbf8cf0c3bfb"),
  SEO("Seo", "Héros", "https://wd40.theking90000.be/files/284eae01-4192-4e41-902b-88278be89756"),
  HAE_IN(
      "Hae-in", "Héros", "https://wd40.theking90000.be/files/e4e0159f-f47b-4d78-83a8-317498be57a8"),
  MYEONG(
      "Myeong", "Héros", "https://wd40.theking90000.be/files/d11cb815-4b68-42f6-aded-d841061e528d"),
  SHIRONE(
      "Shirone",
      "Héros",
      "https://wd40.theking90000.be/files/1ba8be5f-4e98-4a2f-97f4-555d4c1761b4"),
  JIN("Jin", "Héros", "https://wd40.theking90000.be/files/e8fcd4f1-6fc4-4b78-a122-ee394a9767b3"),
  CASSIAN(
      "Cassian",
      "Héros",
      "https://wd40.theking90000.be/files/4ad3aeec-6baf-4181-9149-c70f3303088a"),
  BAM("Bam", "Héros", "https://wd40.theking90000.be/files/8e596b47-732f-4ce7-8545-a7a179444e3e"),
  ANGELA(
      "Angela", "Héros", "https://wd40.theking90000.be/files/03533907-b2d8-4417-9e98-96cd7a68dba9"),
  JANICA(
      "Janica", "Héros", "https://wd40.theking90000.be/files/c623ec2d-aa0b-446c-96a4-8e118cd095ae"),
  CASSIE(
      "Cassie", "Héros", "https://wd40.theking90000.be/files/b79d8e44-bf0e-4440-815f-00f409b6d1e1"),
  DESIR(
      "Desir", "Héros", "https://wd40.theking90000.be/files/ef561241-12f6-4d14-9a89-4869be108fea"),

  // Vilains
  ENGEN(
      "Engen",
      "Vilains",
      "https://wd40.theking90000.be/files/3916a665-a902-4607-92df-ebd6d09ae9b1"),
  GIGYU(
      "Gigyu",
      "Vilains",
      "https://wd40.theking90000.be/files/ea23b61a-4652-4637-bb2a-5d5eaa0187d7"),
  WOO("Woo", "Vilains", "https://wd40.theking90000.be/files/00eb6471-c1f6-4cfa-904a-00c14fefc478"),
  BREEDER(
      "Breeder",
      "Vilains",
      "https://wd40.theking90000.be/files/53e72ba7-6335-4ce0-8603-63b0fb9a6c2a"),
  LORD(
      "Lord", "Vilains", "https://wd40.theking90000.be/files/838ffe5b-0c40-486a-a8c6-ffff2a1e9026"),
  CHEON(
      "Cheon",
      "Vilains",
      "https://wd40.theking90000.be/files/06e0fd61-8146-4143-8b4d-9bc7fa3a4ed3"),
  JEONG(
      "Jeong",
      "Vilains",
      "https://wd40.theking90000.be/files/f864a170-7afe-4ecd-9ea5-a578797f4968"),
  GEOM(
      "Geom", "Vilains", "https://wd40.theking90000.be/files/ec65441a-162b-424d-8736-6e164fb7574a"),
  SAYEON(
      "Sayeon",
      "Vilains",
      "https://wd40.theking90000.be/files/b88b2d07-c823-49bc-8f16-4906e301586d"),
  DONGTAE(
      "Dongtae",
      "Vilains",
      "https://wd40.theking90000.be/files/bffc9937-6175-4ad5-812f-3c1d638e0ab1"),
  ZEON(
      "Zeon", "Vilains", "https://wd40.theking90000.be/files/18f2abd2-6781-43a1-b394-288d72beae2d"),
  ZHUO_FAN(
      "Zhuo Fan",
      "Vilains",
      "https://wd40.theking90000.be/files/27011d9d-0c46-4f04-ac68-2709e53cc811"),

  // Anti-Héros
  IHWA(
      "Ihwa",
      "Anti-Héros",
      "https://wd40.theking90000.be/files/01efd445-29d7-4ab5-bcc3-54f978c8c507"),
  MIN(
      "Min",
      "Anti-Héros",
      "https://wd40.theking90000.be/files/05e410e5-e393-49a2-ab22-85c917b99142"),
  ISLAT(
      "Islat",
      "Anti-Héros",
      "https://wd40.theking90000.be/files/6d5e9a2d-fd35-4e6c-ab3e-a49e8653f236"),
  KANG(
      "Kang",
      "Anti-Héros",
      "https://wd40.theking90000.be/files/ad7e2bea-794e-4fbc-9159-0213ff67311b"),
  LLOYD(
      "Lloyd",
      "Anti-Héros",
      "https://wd40.theking90000.be/files/839901db-82fb-413f-898a-4fa0e200c478"),

  // Duo
  SEOL_JIN(
      "Seol-Jin",
      "Duo Player",
      "https://wd40.theking90000.be/files/63b6be5d-d456-4a92-a4e8-790340af8bd5"),
  EXCALIBUR(
      "Excalibur",
      "Duo Player",
      "https://wd40.theking90000.be/files/b21302ea-8985-4969-9ce1-c4d8013fc237"),
  SUNLESS(
      "Sunless",
      "Duo Shadow Slave",
      "https://wd40.theking90000.be/files/9fbf525d-e3a5-41f5-8898-592cf023d77b"),
  NEPHIS(
      "Nephis",
      "Duo Shadow Slave",
      "https://wd40.theking90000.be/files/a0abf57a-d078-4e90-baae-02cad1232bf7"),

  // Hybrides
  YUTUBA(
      "Yutuba",
      "Hybrides",
      "https://wd40.theking90000.be/files/59144898-8ed9-4565-8733-06dffe6268ad"),
  CHAERIN(
      "Chaerin",
      "Hybrides (Héros)",
      "https://wd40.theking90000.be/files/f4200fed-90bf-4957-b0af-9ac6dcf49f4f"),
  CHAERINVILAINE(
      "Chaerin",
      "Hybrides (Vilains)",
      "https://wd40.theking90000.be/files/327d154f-c50d-4cc7-8941-b23660836c64"),

  // Solitaires
  JIN_WOO(
      "Jin-Woo",
      "Solitaires",
      "https://wd40.theking90000.be/files/9b191521-0d38-4cf5-9017-eeb7e794585f"),
  TIAN_YE(
      "Tian Ye",
      "Solitaires",
      "https://wd40.theking90000.be/files/bf9b5569-ff1b-4e3c-ade1-72f90c153dc4"),
  KIM(
      "Kim",
      "Solitaires",
      "https://wd40.theking90000.be/files/0456d36e-2050-4234-9021-2fd59face311"),
  JOONGHYUK(
      "Joonghuyk",
      "Solitaires",
      "https://wd40.theking90000.be/files/31fe3268-b3eb-4e2c-9733-26e3cdfa7c36");

  private final String displayName;
  private final String winCondition;
  private final String imageUrl;

  ManhwaRole(final String displayName, final String winCondition, final String imageUrl) {
    this.displayName = displayName;
    this.winCondition = winCondition;
    this.imageUrl = imageUrl;
  }

  @Override
  public String id() {
    return this.name();
  }

  @Override
  public String displayName() {
    return this.displayName;
  }

  @Override
  public String winCondition() {
    return this.winCondition;
  }

  @Override
  public String imageUrl() {
    return this.imageUrl;
  }
}
