package com.designMode.adapter.clsadp;

/**
 * @Author zwb
 * @DATE 2020/1/3 11:03
 */
public class ClsAdapter extends AC implements IDC{

    @Override
    public int outputDC() {
        return outputAC()/44;
    }

    public static void main(String[] args) {
        ClsAdapter adapter = new ClsAdapter();
        System.out.println("交流电电压:" + adapter.outputAC());
        System.out.println("直流电电压:" + adapter.outputDC());
    }
}
