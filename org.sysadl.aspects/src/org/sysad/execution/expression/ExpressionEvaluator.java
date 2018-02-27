package org.sysad.execution.expression;

import org.sysadl.context.SysADLContext;
import org.sysadl.context.exceptions.ContextException;

import org.sysadl.AdditiveExpression;
import org.sysadl.AssignmentExpression;
import org.sysadl.BooleanLiteralExpression;
import org.sysadl.ClassificationExpression;
import org.sysadl.ConditionalLogicalExpression;
import org.sysadl.ConditionalTestExpression;
import org.sysadl.EnumValueLiteralExpression;
import org.sysadl.EqualityExpression;
import org.sysadl.Expression;
import org.sysadl.FeatureReference;
import org.sysadl.LeftHandSide;
import org.sysadl.LogicalExpression;
import org.sysadl.MultiplicativeExpression;
import org.sysadl.NameExpression;
import org.sysadl.NaturalLiteralExpression;
import org.sysadl.NullLiteralExpression;
import org.sysadl.PropertyAccessExpression;
import org.sysadl.RelationalExpression;
import org.sysadl.ShiftExpression;
import org.sysadl.StringLiteralExpression;
import org.sysadl.ThisExpression;

public interface ExpressionEvaluator {
	public Object evaluate(Expression e, SysADLContext context) throws ContextException;
	public Object evaluate(ConditionalTestExpression e, SysADLContext context) throws ContextException;
	public Object evaluate(ConditionalLogicalExpression e, SysADLContext context) throws ContextException;
	public Object evaluate(LogicalExpression e, SysADLContext context) throws ContextException;
	public Object evaluate(EqualityExpression e, SysADLContext context) throws ContextException;
	public Object evaluate(ClassificationExpression e, SysADLContext context) throws ContextException;
	public Object evaluate(RelationalExpression e, SysADLContext context) throws ContextException;
	public Object evaluate(ShiftExpression e, SysADLContext context) throws ContextException;
	public Object evaluate(AdditiveExpression e, SysADLContext context) throws ContextException;
	public Object evaluate(MultiplicativeExpression e, SysADLContext context) throws ContextException;
	public Object evaluate(NameExpression e, SysADLContext context) throws ContextException;
	public Object evaluate(BooleanLiteralExpression e, SysADLContext context) throws ContextException;
	public Object evaluate(NaturalLiteralExpression e, SysADLContext context) throws ContextException;
	public Object evaluate(StringLiteralExpression e, SysADLContext context) throws ContextException;
	public Object evaluate(EnumValueLiteralExpression e, SysADLContext context) throws ContextException;
	public Object evaluate(NullLiteralExpression e, SysADLContext context) throws ContextException;
	public Object evaluate(ThisExpression e, SysADLContext context) throws ContextException;
	public Object evaluate(PropertyAccessExpression e, SysADLContext context) throws ContextException;
	public Object evaluate(FeatureReference e, SysADLContext context) throws ContextException;
	public Object evaluate(AssignmentExpression e, SysADLContext context) throws ContextException;
	public Object evaluate(LeftHandSide e, SysADLContext context) throws ContextException;

}
