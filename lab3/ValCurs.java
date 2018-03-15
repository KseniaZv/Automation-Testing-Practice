package csv;


import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("ValCurs")
public class ValCurs {

    @XStreamImplicit(itemFieldName = "Valute")
    private List<Valute> cur = new ArrayList<>();

    public List<Valute> getCur() {
        return cur;
    }

    public void setCur(List<Valute> bans) {
        this.cur = bans;
    }


}