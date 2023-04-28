import design.M348DesignTicTacToe;

public class DesignSolution {
    public static void main(String[] args) {
//        M707DesignLinkedList head = new M707DesignLinkedList();
//        head.addAtHead(1);
//        head.addAtTail(3);
//        head.addAtIndex(3,2);

//        M707DoublyLinkedList head = new M707DoublyLinkedList();
//        head.addAtHead(7);
//        head.addAtTail(4);
//        head.addAtHead(2);
//        head.addAtHead(1);
//        head.addAtIndex(3,0);
//        head.deleteAtIndex(2);
//        head.addAtHead(6);
//        head.addAtTail(4);
//        head.get(4);
//        head.addAtHead(4);
//        head.addAtIndex(5,0);
//        head.addAtHead(6);
//        DoublyNode head = DoublyNode.createMock();
//        E703KthLargestInStream e703 = new E703KthLargestInStream(3, new int[]{4, 5, 8, 2});
//        e703.add(3);  // return 4
//        e703.add(5);  // return 5
//        e703.add(10); // return 5
//        e703.add(9);  // return 8
//        e703.add(4);  // return 8
//        H460LFUCache lfu = new H460LFUCache(2);
//        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
//        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//        lfu.get(1);      // return 1
//        // cache=[1,2], cnt(2)=1, cnt(1)=2
//        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
//        // cache=[3,1], cnt(3)=1, cnt(1)=2
//        lfu.get(2);      // return -1 (not found)
//        lfu.get(3);      // return 3
//        // cache=[3,1], cnt(3)=2, cnt(1)=2
//        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
//        // cache=[4,3], cnt(4)=1, cnt(3)=2
//        lfu.get(1);      // return -1 (not found)
//        lfu.get(3);      // return 3
//        // cache=[3,4], cnt(4)=1, cnt(3)=3
//        lfu.get(4);     // return 4
//        // cache=[4,3], cnt(4)=2, cnt(3)=3
//        H297SerializeDeserializeTree h297 = new H297SerializeDeserializeTree();
//        TreeNode root = h297.deserialize("1,2,3,null,null,4,5,6,7");
//        String s = h297.serialize(root);
//        System.out.println(s);
//        M155MinStack m155 = new M155MinStack();
//        m155.push(512);
//        m155.push(-1024);
//        m155.push(-1024);
//        m155.push(512);
//        m155.pop();
//        m155.getMin();
//        m155.pop();
//        m155.getMin();
//        m155.pop();
//        m155.getMin();
//        M677MapSumPairs m677 = new M677MapSumPairs();
//        m677.insert("apple", 3);
//        m677.sum("ap");
//        m677.insert("app", 2);
//        m677.sum("ap");
//        m677.insert("apple", 2);
//        m677.sum("ap");
//        M211DesignAddSearchStructure m211 = new M211DesignAddSearchStructure();
//        m211.addWord("at");
//        m211.addWord("and");
//        m211.addWord("an");
//        m211.addWord("add");
//        m211.search("a");
//        M1472DesignBrowserHistory m1472 = new M1472DesignBrowserHistory("leetcode.com");
//        m1472.visit("google.com");
//        m1472.visit("facebook.com");
//        m1472.visit("youtube.com");
//        m1472.back(1);
//        m1472.back(1);
//        m1472.forward(1);
//        m1472.visit("linkedin.com");
//        m1472.forward(2);
//        m1472.back(2);
//        m1472.back(7);
//        H642DesignSearchSystem h642 = new H642DesignSearchSystem(new String[]{"uqpewwnxyqxxlhiptuzevjxbwedbaozz","ewftoujyxdgjtazppyztom","pvyqceqrdrxottnukgbdfcr","qtdkgdbcyozhllfycfjhdsdnuhycqcofaojknuqqnozltrjcabyxrdqwrxvqrztkcxpenbbtnnnkfhmebj","jwfbusbwahyugiaiazysqbxkwgcawpniptbtmhqyrlxdwxxwhtumglihrgizrczv","cfptjitfzdcrhw","aitqgitjgrcbacgnaasvbouqsqcwbyskkpsnigtfeecmlkcjbgduban","utsqkmiqqgglufourfdpgdmrkbippffacwvtkpflzrvdlkdxykfpkoqcb","ethtbdopotpamvrwuomlpahtveyw","jiaqkaxovsqtkpdjfbkajpvpyetuoqwnrnpjdhoojbsdvneecsdvgqpyurmsvcy","j","btbnuplyeuccjbernsfbnveillrwdbqledwvpmvdbcugkurrkabtpykhlcogeszclyfuquafouv","hndjzblegevtfkgbjttektox","gtvnlninpvenapyfgmsjdisfnmiktitrutctawosjflvzfkbegnprixzqwzcyhoovsivuwmofsveqkyosowuyamuvy","sawrirvrfrbfagreahrioaombukmdwztbpggnxd","mgdcwptvbvhzyvvumvbjjn","otjvvkegwleyyxtghwgfmlsqlhrlibdvqfinyyebotjpwoaejhtornfgikmifdmwswbqgwhcbzuhrpajxuqicegcptszct","zlondsttyvnnnnxjtoqnlktitwzurissczzbyfsbgpoawodwjpsmavaugnhqtsbeixwl","yehvdehbtmwqkmcjmvpivfzqvevkotwzvjoyfvp","bjximtpayjdcxbrnksbtfnpynzaygygdflowewprqngdadzdhxcpgapjejojrkzrutgcsfpfvpluagniqimfqddldxqiw","bysyrxfykivyauysytgxfhqcrxliulahuizjvozpywrokxujhzpauxwufcxiitukljiiclatfrspqcljjoxpxziumstnhqr","uxtvutlgqapyfltiulwrplesmtowzoyhhjhzihatpuvmutxqgxfawpwypedbz","jzgsdjdawrqfladolduldhpdpagmvllvzamypuqlrpbmhxxadqaqrqavtxeghcyysjynovkiyjtvdluttodtmtocajgttmv","mbijfkmepalhdiubposdksdmmttxblkodcdrxbnxaqebnwliatnxpwaohbwkidia","ljggggbyxwrwanhjonoramexdmgjigrtpz","cqfvkutpipxjepfgsufonvjtotwfxyn","kvseesjazssavispavchdpzvdhibptowhyrrshyntpwkez","nveuzbaosuayteiozmnelxlwkrrrjlwvhejxhupvchfwmvnqukphgoacnazuoimcliubvhv","uwrpwhfdrxfnarxqpkhrylkwiuhzubjfk","bniyggdcloefwy","ihranmhbsahqjxesbtmdkjfsupzdzjvdfovgbtwhqfjdddwhdvrnlyscvqlnqpzegnvvzyymrajvso","lscreasfuxpdxsiinymuzybjexkpfjiplevqcjxlm","uwgnfozopsygnmptdtmmuumahoungpkodwxrcvfymqpeymaqruayvqqgoddgbnhemtsjifhxwiehncswxzrghf","nyfbxgcpfrzyqwfjzgmhuohjhrjizsyjqgmertmooeiaadcmiuyyylpcosnweoyydeauazhzbeaqn","tpylrxbwnkrfxckfdlvrbytaezuzmyscpvruthuvbxjenkeolvqsrjqzizyclzmqtjvnamdansmzyspcfghfprorqprua","nhldlmxpuckxeekipkrzugatjiivtazjbjyxokksyueyjbgmrovbckbxqcqefaiavzsarbbypgmpxe","sylraqsd","xr","xkzpxkhrucyatpatkigvntohihibyisyqtkjdhatdvyvxbjttz","nvnz","blzddwxphkgqfsfzfclwytstpvpzgcdeggdwzukzirscfzcteeuqbmmrfxcnokbbyxkqrxtjfarcefiynwfmy","inuxmuhtdwpuvyludwtokhtalxbuccepsayrjycbcwbtnfholjvkmypodv","awwillrm","xznodxngrstjrwqzmlmigpw","khlxjdtictufdfbkgfusdtaaeuspbbfmtjodflgqofzlqnulkdztflm","nlngmckslyqzjiyiexbropbxnynjcstziluewypboqhqndqsxhtnosrgrameajovsclrgwqjgnztvxrkhwnxkfrf","yroadxhxyacaexrwju","ujxlbpcbxdqrvubifnpzjmmkolyljzjhdegaiowaal","tnfnjgtxbckbpyplucprxcqzhrfjimylmlhdglntfydepltjvklyxesndzuubienhvuaqc","ouedhtkpkg","ygchsrrubucqffewifsxaefwocfaiiupqbomktvrcddggqfgnaycstpccwtbheyaqwhosxajqeqqxzyjsfng","jqqgpjvfkgjh","csowoazaiyejgyixszqmtctpzlkccccqregyhtvxccvrpkupwcyhqatxscevzdfbdqnuyadiyfnhysddfyxpgqtjiogmxsmzbbkr","dlzxdpchkdaztkqtrjmuujgoiae","plcjkwukkyqluxjbhxsyeaqvviinfuujsafwsquidvmutsrukxwrv","yopqbtpoqhpcktjangauzcvvpephhprpaaclbbkgchlqkrwdsaupeizlwxzcpkchoagmrrkwdkthosmrjefgbumnrjsb"}, new int[]{12,9,4,4,1,5,3,4,7,9,2,4,2,3,11,13,1,3,4,10,7,1,9,5,10,14,5,3,2,11,5,14,4,13,11,5,15,8,1,12,2,11,4,2,11,14,9,12,1,7,13,11,7,2,6,10});
//        h642.input('o');
        M348DesignTicTacToe m348 = new M348DesignTicTacToe(2);
        m348.move(0, 1, 1);
        m348.move(1, 1, 2);
        m348.move(1, 0, 1);
    }
}
