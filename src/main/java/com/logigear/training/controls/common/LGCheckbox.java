package com.logigear.training.controls.common;

import com.logigear.training.controls.base.Clickable;

public class LGCheckbox extends Clickable {
    public LGCheckbox(String locator) {
        super();
        this.locator = locator;
    }
    public void check() {
        if (!this.getRuntimeElement().isSelected()) {
            this.getRuntimeElement().click();
        }
    }
    }
