import com.rvp.entity.Branches;
import com.rvp.entity.Insurance;
import com.rvp.entity.InsuranceApplicationDetails;
import com.rvp.entity.InsuranceDetail;
import com.rvp.entity.MutualFund;
import com.rvp.entity.MutualFundApplicationDetails;
import com.rvp.entity.MutualFundDetail;
import com.rvp.entity.UserInfo;
import com.rvp.entity.Users;
import com.rvp.util.Utils;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rav
 */
public class Test {

    final static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String as[]) {
        Session session = Utils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        

           Query query = session.createSQLQuery(
                    "select * from branches s where s.branchName = :name").addEntity(Branches.class).setParameter("name", "");

            System.out.println("Searching");
            Branches branch = (Branches) query.list().get(0);
            System.out.println(branch.getBranchName());
        

        session.getTransaction().commit();
    }
}
