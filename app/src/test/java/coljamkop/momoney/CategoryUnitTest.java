package coljamkop.momoney;

import org.junit.Test;

import coljamkop.momoney.dummy.Category;
import coljamkop.momoney.dummy.Expense;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class CategoryUnitTest {
    @Test
    public void isInGoal_isCorrect() throws Exception {
        Category category = new Category(0.0, 20.0);
        // $0.00 <= $20.00
        assertEquals(true, category.isInGoal());
        category.addExpense(new Expense(10.0, 0));
        // $10.00 <= $20.00
        assertEquals(true, category.isInGoal());
        category.addExpense(new Expense(10.0, 0));
        // $20.00 <= $20.00
        assertEquals(true, category.isInGoal());
        category.addExpense(new Expense(10.0, 0));
        // $30.00 <= $20.00
        assertEquals(false, category.isInGoal());
    }

    @Test
    public void total_isCorrect() throws Exception {
        double total = 0;
        Category category = new Category(0.0, 20.0);
        for(int i = 0; i < 10; i++) {
            category.addExpense(new Expense(10.0, 0));
            total += 10.0;
            assertEquals(total, category.getTotal(), 0.0);
        }

    }
}