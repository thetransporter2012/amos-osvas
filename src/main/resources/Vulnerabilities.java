import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.io.IOException;

public class Vulnerabilities {
    protected ArrayList<Vulnerability> vulnerabilities;

    public Vulnerabilities(String query){
        try {
            Document doc = this.getVulnerabilitiesByQuery(query);

            this.initVulnerabilities(doc);
        } catch (IOException e) {
            System.out.println("could not load vulnerabilties: "+e.getMessage());
        }
    }

    protected Document getVulnerabilitiesByQuery(String query) throws IOException {
        Document doc = Jsoup.connect(
            "http://www.osvdb.org/search/search?search%5Bvuln_title%5D%3Dcisco"
        ).userAgent("Mozilla").get();

        return doc;
    }

    protected void initVulnerabilities(Document doc) {
        //ArrayList<VulnerabilityElement> vuln = new ArrayList<VulnerabilityElement>();

        Elements rows = doc.select("div.thinmcboxd table.full_length tr");
        for (Element row : rows) {
            System.out.println('x'+row.select("td").html()+'x');
            if (row.select("td").html().trim() == "") {

System.out.println("continue");
                continue;
            }

            Vulnerability v = new Vulnerability(
                row.select("td:eq(0)").first().text(),
                row.select("td:eq(1)").first().text(),
                row.select("td:eq(2)").first().text(),
                row.select("td:eq(0) a").first().text()
            );

            this.vulnerabilities.add(v);
        }        
    }

    public ArrayList<Vulnerability> getVulnerabilities() {
        return this.vulnerabilities;
    }
}
