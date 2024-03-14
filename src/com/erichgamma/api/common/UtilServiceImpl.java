package com.erichgamma.api.common;

public class UtilServiceImpl implements UtilService {

    private static UtilService instance = new UtilServiceImpl();

    private UtilServiceImpl(){}

    public static UtilService getInstance(){
        return instance;
    }

    @Override
    public int createRandomInt(int begin, int range) {
        return begin + (int)(Math.random() * range);
    }

    @Override
    public double createRandomDouble(double begin, double range) {
        return Math.floor((begin + Math.random() * range) * 10) / 10.0;
    }

    @Override
    public String createRandomName(){
        String[] names = {"이정재", "마동석", "송강호", "윤여정", "황정민",
                          "정우성", "이병헌", "현 빈", "유해진", "손석구",
                          "전도연", "손예진", "하지원", "김하늘", "송중기",
                          "하정우", "장동건", "원 빈", "박해일", "소지섭"};
        return names[this.createRandomInt(0, 20)];
    }

    @Override
    public String createRandomUsername() {
        String username = "";
        for(; username.length() < 5; username += String.valueOf((char)('a' + this.createRandomInt(0, 26))));
        return username;
    }

    @Override
    public String createRandomTitle(){
        String[] titles = {"국민경제자문회의의 조직·직무범위",
                "국회는 국민의 보통·평등·직접·비밀선거에 의하여 선출된 국회의원",
                "대통령은 법률에서 구체적으로 범위를 정하여 위임받은 사항과 법률을 집행",
                "계엄을 선포한 때",
                "대법원장의 임기",
                "법률안에 이의",
                "모든 국민은 법률이 정하는 바에 의하여 공무담임권",
                "재산권의 행사",
                "국민의 자유와 권리",
                "국무회의는 정부의 권한에 속하는 중요한 정책을 심의"
        };
        return titles[this.createRandomInt(0, 10)];
    }

    @Override
    public String createRandomContent(){
        String[] contents = {"국민경제자문회의의 조직·직무범위 기타 필요한 사항은 법률로 정한다. 국회의원은 현행범인인 경우를 제외하고는 회기중 국회의 동의없이 체포 또는 구금되지 아니한다.",
                "국회는 국민의 보통·평등·직접·비밀선거에 의하여 선출된 국회의원으로 구성한다. 제안된 헌법개정안은 대통령이 20일 이상의 기간 이를 공고하여야 한다.",
                "대통령은 법률에서 구체적으로 범위를 정하여 위임받은 사항과 법률을 집행하기 위하여 필요한 사항에 관하여 대통령령을 발할 수 있다. 체포·구속·압수 또는 수색을 할 때에는 적법한 절차에 따라 검사의 신청에 의하여 법관이 발부한 영장을 제시하여야 한다. 다만, 현행범인인 경우와 장기 3년 이상의 형에 해당하는 죄를 범하고 도피 또는 증거인멸의 염려가 있을 때에는 사후에 영장을 청구할 수 있다.",
                "계엄을 선포한 때에는 대통령은 지체없이 국회에 통고하여야 한다. 국회에 제출된 법률안 기타의 의안은 회기중에 의결되지 못한 이유로 폐기되지 아니한다. 다만, 국회의원의 임기가 만료된 때에는 그러하지 아니하다.",
                "대법원장의 임기는 6년으로 하며, 중임할 수 없다. 법관은 헌법과 법률에 의하여 그 양심에 따라 독립하여 심판한다. 국가안전보장회의의 조직·직무범위 기타 필요한 사항은 법률로 정한다.",
                "법률안에 이의가 있을 때에는 대통령은 제1항의 기간내에 이의서를 붙여 국회로 환부하고, 그 재의를 요구할 수 있다. 국회의 폐회중에도 또한 같다. 모든 국민은 거주·이전의 자유를 가진다.",
                "모든 국민은 법률이 정하는 바에 의하여 공무담임권을 가진다. 재판의 심리와 판결은 공개한다. 다만, 심리는 국가의 안전보장 또는 안녕질서를 방해하거나 선량한 풍속을 해할 염려가 있을 때에는 법원의 결정으로 공개하지 아니할 수 있다.",
                "재산권의 행사는 공공복리에 적합하도록 하여야 한다. 국무위원은 국무총리의 제청으로 대통령이 임명한다. 위원은 탄핵 또는 금고 이상의 형의 선고에 의하지 아니하고는 파면되지 아니한다.",
                "국민의 자유와 권리는 헌법에 열거되지 아니한 이유로 경시되지 아니한다. 훈장등의 영전은 이를 받은 자에게만 효력이 있고, 어떠한 특권도 이에 따르지 아니한다.",
                "국무회의는 정부의 권한에 속하는 중요한 정책을 심의한다. 모든 국민은 양심의 자유를 가진다. 대법원장과 대법관이 아닌 법관은 대법관회의의 동의를 얻어 대법원장이 임명한다."
        };
        return contents[this.createRandomInt(0, 10)];
    }

    @Override
    public String createRandomCompany() {
        String[] companies = {"구글", "엔비디아", "메타", "삼성", "엘지", "애플"};
        return companies[this.createRandomInt(0, 6)];
    }

    @Override
    public String createRandomJob(){
        String[] names = {"의사", "검사", "변호사", "개발자", "회계사"};
        return names[this.createRandomInt(0, 5)];
    }
}
