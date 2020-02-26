package com.designMode.adapter.objadp;

import com.designMode.adapter.clsadp.AC;
import com.designMode.adapter.clsadp.IDC;

/**
 * @Author zwb
 * @DATE 2020/1/3 11:23
 */
public class ObjAdapter implements IDC {
    private AC ac;

    public ObjAdapter(AC ac){
        this.ac = ac;
    }

    public int outputAC(){
        return ac.outputAC();
    }

    @Override
    public int outputDC() {
        return ac.outputAC()/44;
    }

    public static void main(String[] args) {
        ObjAdapter adapter = new ObjAdapter(new AC());
        System.out.println("交流电电压:" + adapter.outputAC());
        System.out.println("直流电电压:" + adapter.outputDC());
    }
}
