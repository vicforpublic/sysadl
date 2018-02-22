package org.sysadl.aspects;

import org.eclipse.emf.common.util.EList;
import org.sysadl.context.SysADLContext;
import org.sysadl.context.exceptions.ContextException;
import sysADL_Sintax.Executable;
import sysADL_Sintax.Expression;
import sysADL_Sintax.NameExpression;
import sysADL_Sintax.ReturnStatement;
import sysADL_Sintax.Statement;

/**
 * 
 * This class is responsible for evaluating Expressions and running Executables
 * 
 * @author Eduardo
 *
 */
public class SysADLExecutionEngine {
	private SysADLStatementInterpreter interpreter;

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
		return null;
	}
	
	public Object evaluate(NameExpression n, SysADLContext context) throws ContextException {
		return context.findByName(n.getCite().getName());
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

	}

	private static SysADLExecutionEngine instance = new SysADLExecutionEngine();

	public static SysADLExecutionEngine getInstance() {
		return instance;
	}
}
