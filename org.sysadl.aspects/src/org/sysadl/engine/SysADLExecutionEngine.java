package org.sysadl.engine;

import org.eclipse.emf.common.util.EList;
import org.sysad.execution.expression.ExpressionEvaluator;
import org.sysad.execution.expression.ExpressionEvaluatorImpl;
import org.sysadl.context.SysADLContext;
import org.sysadl.context.exceptions.ContextException;
import org.sysadl.execution.StatementsInterpreterImpl;

import org.sysadl.Executable;
import org.sysadl.Expression;
import org.sysadl.NameExpression;
import org.sysadl.ReturnStatement;
import org.sysadl.Statement;

/**
 * 
 * This class is responsible for evaluating Expressions and running Executables
 * 
 * @author Eduardo
 *
 */
public class SysADLExecutionEngine {
	private SysADLStatementInterpreter interpreter;
	private ExpressionEvaluator evaluator;
	/**
	 * Evaluate an expression
	 * 
	 * @param e
	 *            SysADL expression
	 * @param context
	 *            map ID-value with available variables
	 * @return result of the evaluation
	 */
	public Object evaluate(Expression e, SysADLContext context) throws ContextException {
		return evaluator.evaluate(e, context);
	}

	/**
	 * Executes an executable
	 * 
	 * @param e
	 *            the executable
	 * @param context
	 *            map ID-value with available variables
	 * @return the result of the execution
	 */
	public Object execute(Executable e, SysADLContext context) {
		context.setThis(e); // @fixme the executable will be the this var, this might change
		EList l = e.getBody();
		try { // FIXME should this try-catch be here?
			for (Object s : e.getBody()) {
				if (s instanceof ReturnStatement) { // only returns if find a return statement
					return evaluate(((ReturnStatement) s).getValue(), context);
				} else
					interpreter.run((Statement) s, context);
			}
		} catch (ContextException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
	
	private SysADLExecutionEngine() {
		evaluator = new ExpressionEvaluatorImpl();
		interpreter = new StatementsInterpreterImpl();
	}

	private static SysADLExecutionEngine instance = new SysADLExecutionEngine();

	public static SysADLExecutionEngine getInstance() {
		return instance;
	}
}
