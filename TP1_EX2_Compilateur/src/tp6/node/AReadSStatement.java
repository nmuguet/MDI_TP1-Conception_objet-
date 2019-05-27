/* This file was generated by SableCC (http://www.sablecc.org/). */

package tp6.node;

import tp6.analysis.*;

@SuppressWarnings("nls")
public final class AReadSStatement extends PStatement
{
    private PReadS _readS_;

    public AReadSStatement()
    {
        // Constructor
    }

    public AReadSStatement(
        @SuppressWarnings("hiding") PReadS _readS_)
    {
        // Constructor
        setReadS(_readS_);

    }

    @Override
    public Object clone()
    {
        return new AReadSStatement(
            cloneNode(this._readS_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAReadSStatement(this);
    }

    public PReadS getReadS()
    {
        return this._readS_;
    }

    public void setReadS(PReadS node)
    {
        if(this._readS_ != null)
        {
            this._readS_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._readS_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._readS_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._readS_ == child)
        {
            this._readS_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._readS_ == oldChild)
        {
            setReadS((PReadS) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
