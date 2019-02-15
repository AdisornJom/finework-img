package com.fineworkimg.core.util;

/**
 * @author MR Aekasit Sengnualnim (Aek) System Analyst
 *
 * Progress Software Co.,Ltd Fl. 6-7 306 Supha Road, Phomphlab
 * Phomphlabsattupai, Bangkok 10100 Thailand Tel :+66 (0) 2867 5020 Mobile : +66
 * 91004 1009 Skype : s.aekasit MSN : aekasit.se@gmail.com Email :
 * aekasit.s@kasikornbank.com Website http://www.kasikornbank.com
 *
 * @create 13-05-2015 4:39:44 PM
 */
public interface Constants {

    Integer INTERVAL_POLL = 8;   // second

    /*
    USER
     */
    Integer USER_TYPE_NORMAL = 1;
    Integer USER_TYPE_AGENT = 2;
    Integer USER_STATUS_DELETE = 0;
    Integer USER_STATUS_NORMAL = 1;
    Integer USER_STATUS_INACTIVE = 2;

    /*
    USER_TXN
     */
    Integer USER_TXN_TYPE_DEPOSIT = 1;
    Integer USER_TXN_TYPE_WITHDRAW = 2;
    //
    Integer USER_TXN_STATUS_ONPROCESS = 1;
    Integer USER_TXN_STATUS_ACCEPT = 2;
    Integer USER_TXN_STATUS_REJECT = 3;
    Integer USER_TXN_STATUS_CANCEL = 4;
    Integer USER_TXN_STATUS_LOCK = 5;
    Integer USER_TXN_STATUS_TRANSOK = 6;
    Integer USER_TXN_STATUS_TRANSCANCEL = 7;
    Integer USER_TXN_STATUS_CHECK = 8;

    Integer USER_TXN_PAYCHNID_BANKING = 1;
    Integer USER_TXN_PAYCHNID_ONLINE = 2;
    /*
    USER_FUNDS_DATA
     */
    Integer USER_FUNDS_DATA_TYPE_DEPOSIT = 1;
    Integer USER_FUNDS_DATA_TYPE_WITHDRAW = 2;
    Integer USER_FUNDS_DATA_TYPE_ADJUST_CASH = 3;
    Integer USER_FUNDS_DATA_TYPE_POINT = 4;
    Integer USER_FUNDS_DATA_TYPE_PROMOTION = 5;
    Integer USER_FUNDS_DATA_TYPE_TRANFER = 6;
    Integer USER_FUNDS_DATA_TYPE_ADJUST_POINT = 7;
    Integer USER_FUNDS_DATA_TYPE_ADJUST_AGENT = 8;
    //
    Integer USER_FUNDS_DATA_STS_PENDING = 1;
    Integer USER_FUNDS_DATA_STS_NORMAL = 2;
    Integer USER_FUNDS_DATA_STS_REJECT = 3;
    Integer USER_FUNDS_DATA_STS_CANCEL = 4;
    Integer USER_FUNDS_DATA_STS_LOCK = 5;
    Integer USER_FUNDS_DATA_STS_TRANSOK = 6;
    Integer USER_FUNDS_DATA_STS_TRANSCANCEL = 7;
    Integer USER_FUNDS_DATA_STS_TRANSAPIFAIL = 8;
    Integer USER_FUNDS_DATA_STS_TRANSAPIFAILRESULTSUCCESS = 9;
    Integer USER_FUNDS_DATA_STS_TRANSAPIFAILACCEPT = 9;
    Integer USER_FUNDS_DATA_STS_TRANSAPIFAILRESULTFAIL = 10;

    /*
    api id follow up with table core_api_name
     */
    Integer API_MAIN = 1;
    Integer API_TOP = 2;
    Integer API_BET168 = 3;
    Integer API_BET125 = 4;
    Integer API_VENETIAN = 5;
    Integer API_WYNN = 6;
    Integer API_RACINGGAMING = 8;
    Integer API_LOTTO = 9;
    Integer API_COCKFIGHT = 11;
    Integer API_POKER = 12;
    Integer API_FISHINGWORLD = 13;
    Integer API_ALLBET = 14;
    Integer API_SPADEGAMING = 15;
    Integer API_N2LIVE = 16;
    Integer API_M168 = 17;
    Integer API_CQ9 = 18;

    //API check result
    public static final int RTN_SUCCESS = 1;
    public static final int RTN_NON_SUCCESS = 2;
    public static final int RTN_TIMEOUT = 3;
    public static final int RTN_ABORT = 4;

    /*
    api status follow up with table core_api_name
     */
    Integer API_STATUS_CLOSE = 0;
    Integer API_STATUS_OPEN = 1;
    Integer API_STATUS_MA = 2;
    Integer API_STATUS_TRANSFER_OFF = 3;

    String API_STATUS_REASON1 = "1";
    String API_STATUS_REASON2 = "2";
    String API_STATUS_REASON3 = "3";
    /*
    /*
    ftp folder path
     */
    String FTP_PATH_BASE = "/base/";
    String FTP_PATH_ADV = "/adv/";
    String FTP_PATH_PRO = "/pro/";
    String FTP_PATH_BANNER = "/banner/";
    String FTP_PATH_SLIP = "/slip/";
    String FTP_PATH_INFO = "/info/";

    /*
    Email template
     */
    String EMAIL_REGISTER = "register";
    String EMAIL_FORGET_PASSWORD = "forget_password";
    String EMAIL_NEW_PASSWORD = "new_password";
    String EMAIL_SEND_CUSTOMER = "send_email";
    /*
    seq
     */
    String SEQ_API_GAME_GR = "api_game_gr_seq";
    String SEQ_CORE_USER = "core_user_seq";
    String SEQ_CORE_USER_REGISTER = "core_user_register_seq";
    String SEQ_CORE_USER_REGISTER_USER = "core_user_register_user_seq";
    String SEQ_CORE_USER_REGISTER_ADMIN = "core_user_register_admin_seq";
    String SEQ_CORE_USER_FUNDS_DATA = "core_user_funds_data_seq";
    String SEQ_CORE_USER_TXN = "core_user_txn_seq";
    String CORE_AGENT_GROUP_SEQ = "core_agent_group_seq";

    /*
    AGENT_REGISTER
     */
    Integer AGENT_STATUS_NORMAL = 0;
    Integer AGENT_STATUS_ACCEPT = 1;
    Integer AGENT_STATUS_REJECT = 2;
    Integer AGENT_STATUS_CANCEL = 3;

    /*
     PROMOTION
     */
    Integer PRO_STATUS_SHOW = 1;
    Integer PRO_STATUS_HIDE = 0;
    Integer PRO_STATUS_CLOSE = 2;

    /*
    PROMOTION_TYPE
     */
    Integer PRO_TYPE_PERSEN = 1;
    Integer PRO_TYPE_AMOUNT = 2;
    Integer PRO_TYPE_REFUND = 3;

    /*
    PAYMENT STATUS
     */
    Integer PAY_STATUS_OPEN = 1;
    Integer PAY_STATUS_CLOSE = 0;
    Integer PAY_STATUS_SUSPEND = -1;

    /*
     MESSAGE_TYPE
     */
    Integer GLOBAL_TYPE_MESSAGE = 1;
    Integer GLOBAL_TYPE_EMAIL = 2;
    /*
    STATUS SEND EMAIL
     */
    Integer SEND_EMAIL_PROGRESS = 1;
    Integer SEND_EMAIL_CORRECT = 2;
    Integer SEND_EMAIL_INCORRECT = 3;

//    String SERVICE_REGISTER = "register";
//    String SERVICE_BALANCE = "balance";
//    String SERVICE_DEPOSIT = "deposit";
//    String SERVICE_WITHDRAW = "withdraw";
//    String SERVICE_LOGIN = "login";
//    String SERVICE_REQUEST = "request";
//    String SERVICE_RESPONSE = "response";
    String SERVICE_TOP = "S1";
    String SERVICE_BET168 = "S2";
    String SERVICE_BET125 = "S3";
    String SERVICE_VENETIAN = "C1";
    String SERVICE_WYNN = "C2";
    String SERVICE_COCKFIGHT = "C3";
    String SERVICE_ALLBET = "C4";
    String SERVICE_N2LIVE = "C5";
    String SERVICE_RACINGGAMING = "G1";
    String SERVICE_FISHINGWORLD = "G3";
    String SERVICE_POKER = "G2";
    String SERVICE_LOTTO = "LOTTO999";
    String SERVICE_SPADEGAMING = "G4";
    String SERVICE_ENABLE = "true";
    String SERVICE_GGAMING = "G3";
    String SERVICE_HELP2PAY = "Help2Pay";
    String SERVICE_M168 = "M168";
    String SERVICE_CQ9 = "G5";
    String SERVICE_PAYMENT = "payment";

    //Transfer
    boolean TRANSFER_ALLOW = true;
    boolean TRANSFER_DENY = false;

    //SpadeGaming
    String API_SG_FREE_COMERCIAL = "FREE_COMERCIAL";

    String LOG_DEPOSIT = "deposit";
    String LOG_DEPOSIT_CONFIRM = "confrim-deposit";
    String LOG_WITHDRAW = "withdraw";
    String LOG_REGISTER = "register";
    String LOG_LOGIN = "login";
    String LOG_GAME_LIST = "game-list";
    String LOG_HANDICAPS = "handicaps";

    //API
    String API_CODE_TOP_KEY = "(S1)";
    String API_CODE_TOP = "api.topsport";
    String API_CODE_BET168_KEY = "(S2)";
    String API_CODE_BET168 = "api.bet168";
    String API_CODE_BET125_KEY = "(S3)";
    String API_CODE_BET125 = "api.bet125";
    String API_CODE_SC_KEY = "(C1)";
    String API_CODE_SC = "api.venetian";
    String API_CODE_ALLBET_KEY = "(C4)";
    String API_CODE_ALLBET = "api.allbet";
    String API_CODE_LOTTO999_KEY = "";
    String API_CODE_LOTTO999 = "api.lotto";
    String API_CODE_COCKFIGHT_KEY = "(C3)";
    String API_CODE_COCKFIGHT = "api.cockfight";
    String API_CODE_GR_KEY = "(G1)";
    String API_CODE_GR = "api.racing_games";
    String API_CODE_FISHINGWORLD_KEY = "(G3)";
    String API_CODE_FISHINGWORLD = "api.fishworld";
    String API_CODE_SG = "api.sg_gaming";
    String API_CODE_SG_KEY = "(G4)";
    String API_CODE_IDNPOKER_KEY = "(G2)";
    String API_CODE_IDNPOKER = "api.idnpoker";
    String API_CODE_N2LIVE_KEY = "(C5)";
    String API_CODE_N2LIVE = "api.n2live";
    String API_CODE_HELP2PAY = "api.help2pay";
    String API_CODE_M168_KEY = "(C6)";
    String API_CODE_M168 = "api.m168";
    String API_CODE_CQ9_KEY = "(G5)";
    String API_CODE_CQ9 = "api.cq9";
    String API_CODE_PAYMENT = "api.payment";

    //MA
    String API_CODE_MA1 = "api.reason1";
    String API_CODE_MA2 = "api.reason2";
    String API_CODE_MA3 = "api.reason3";
    String API_CODE_MA4 = "api.reason4";

    //wallet_type
    String API_MAIN_WALLET = "MAIN_WALLET";
    String API_SINGLE_WALLET = "SINGLE_WALLET";

    //Send Email
    Integer LIMIT_SEND_EMAIL = 2000;
    Integer LIMIT_SEND_EMAIL_PER_TIME = 100;
    //Login by
    String LOGIN_BY_EMAIL = "email";

    String DATE_TIME_PATTERN = "dd-MM-yyyy HH:mm";
    String DATE_PATTERN = "dd-MM-yyyy";

    /*common status
      1=open
      0=close
     */
    Integer COMMON_STATUS_OPEN = 1;
    Integer COMMON_STATUS_CLOSE = 0;

    //Group Type Banner
    Integer BANNER_GROUP1_TYPE = 1;
    Integer BANNER_GROUP2_TYPE = 2;
    Integer BANNER_GROUP3_TYPE = 3;

    //Adjust money
    int ADJUST_ADD = 1;
    int ADJUST_SUBTRACT = 2;
    int ADJUST_ADDFROMPRO = 3;
    int ADJUST_ADD_AGENT = 4;
    int ADJUST_ADD_POKER = 5;
    int ADJUST_SUBTRACT_POKER = 6;
    int ADJUST_ADD_LOTTO = 7;
    int ADJUST_SUBTRACT_LOTTO = 8;

    //Role AdminUser
    Integer ROLE_STAFF = 1;
    Integer ROLE_ADMIN = 2;
    Integer ROLE_AUDIT = 3;
    Integer ROLE_SUPER = 4;

    //team playing 365Sport
    String HOME_BET_PLAYING = "1";
    String AWAY_BET_PLAYING = "2";

    //limit size insert  batchSize
    int MSG_BATCH_SIZE = 1000;

    String LINK_TARGET_BLANK = "_blank";
    String LINK_TARGET_SELF = "_self";

    //advertisement Type
    Integer DESKTOP_TYPE = 1;
    Integer MOBILE_TYPE = 2;
    //picture advertisement on mobile less than or equal to 4
    Integer PICTURE_ADV_MOBILE = 4;

    /*
     BankList Status
     */
    Integer BANK_STATUS_CLOSE = 0;
    Integer BANK_STATUS_OPEN = 1;

    /*
     CORE BANKACCOUNT TYPE
     */
    String BANK_ACCOUNT_DEPOSIT_TYPE = "DEPOSIT";
    String BANK_ACCOUNT_WITHDRAW_TYPE = "WITHDRAW";

    /*
     CORE SYSTEM MAINTENANCE
     */
    String SYSTEM_MAINTENANCE_MAIN_SYSTEM_CODE = "MAIN_SYSTEM";
    String SYSTEM_MAINTENANCE_DEPOSIT_CODE = "DEPOSIT";
    String SYSTEM_MAINTENANCE_WITHDRAW_CODE = "WITHDRAW";
    String SYSTEM_MAINTENANCE_EXCHANGE_POINT_CODE = "EXCHANGE_POINT";

    //Affiliate
    Integer AFFILATE_DEVIDENEND_PENDING = 1;
    Integer AFFILATE_DEVIDENEND_COMPLETE = 2;
    Integer AFFILATE_DEVIDENEND_CANCEL = 3;

    //PAYMENT_VALIDATE
    String PAYMENT_VALIDATE_TRUE = "1";
    String PAYMENT_VALIDATE_FALSE = "0";
    String PAYMENT_REGISTER_TRUE = "1";
    String PAYMENT_REGISTER_FALSE = "0";
    
    Integer COMMON_OPEN_STATUS=1;//ใช้งาน
    Integer COMMON_CLOSE_STATUS=2;//ปิดใช้งาน
}
