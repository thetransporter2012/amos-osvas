import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.io.IOException;

public class Vulnerabilities {
    protected ArrayList<Vulnerability> vulnerabilities = null;

    public Vulnerabilities(String query){
        System.out.println("Vulnerabilities(String query)");
        try {
            Document doc = this.getVulnerabilitiesByQuery(query);

            this.initVulnerabilities(doc);
        } catch (IOException e) {
            System.out.println("could not load vulnerabilties: "+e.getMessage());
        }
    }

    protected Document getVulnerabilitiesByQuery(String query) throws IOException {
        Document doc = Jsoup.connect(
            "http://www.osvdb.org/search/search?search%5Bvuln_title%5D%3D" + query
        ).userAgent("Mozilla").timeout(3000).get();

        return doc;
    }

    protected void initVulnerabilities(Document doc) {
        Elements rows = doc.select("div.thinmcboxd table.full_length tr");
        for (Element row : rows) {
            System.out.println("html: "+row.html());
            if (null == row.select("td").first() || null == row.select("td:eq(1)").first()) {
                System.out.println("continue ...");
                continue;
            }

            System.out.println("adding Vulnerability");
            Vulnerability v = new Vulnerability();
            v.addElements(
                row.select("td:eq(0)").first().text(),
                row.select("td:eq(1)").first().text(),
                row.select("td:eq(2)").first().text(),
                row.select("td:eq(0) a").first().attr("href")
            );
            
            if (this.vulnerabilities == null) {
                this.vulnerabilities = new ArrayList<Vulnerability>();
            }
            this.vulnerabilities.add(v);
        }        
    }

    public ArrayList<Vulnerability> getVulnerabilities() {
        return this.vulnerabilities;
    }
}
