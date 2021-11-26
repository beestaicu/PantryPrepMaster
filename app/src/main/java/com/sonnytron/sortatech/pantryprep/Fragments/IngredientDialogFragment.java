package com.sonnytron.sortatech.pantryprep.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.sonnytron.sortatech.pantryprep.Activity.HomeActivity;
import com.sonnytron.sortatech.pantryprep.Models.Ingredient;
import com.sonnytron.sortatech.pantryprep.R;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sonnyrodriguez on 8/19/16.
 */
public class IngredientDialogFragment extends DialogFragment {



    private EditText etIngredientTitle;
    private Button btSave;
    private Ingredient mIngredient;
    private RadioGroup mGroup;

    @BindView(R.id.btnCancelIngredient) Button btnCancel;


    public IngredientDialogFragment() {

    }

    public static IngredientDialogFragment newInstance(String title) {
        IngredientDialogFragment fragment = new IngredientDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.ingredient_dialog_fragment, container);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mIngredient = new Ingredient();
        Date mDate = new Date();

        mIngredient.setExpDate(mDate);
        etIngredientTitle = (EditText) view.findViewById(R.id.etIngredientAddTitle);

        btSave = (Button) view.findViewById(R.id.btSaveIngredient);

        mGroup = (RadioGroup) view.findViewById(R.id.radioGroupType);
        mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                View radioButton = radioGroup.findViewById(i);
                int index = radioGroup.indexOfChild(radioButton);
                switch (index) {
                    case 0:
                        mIngredient.setType("protein");
                        break;
                    case 1:
                        mIngredient.setType("veggies");
                        break;
                    case 2:
                        mIngredient.setType("dairy");
                        break;
                    case 3:
                        mIngredient.setType("fruit");
                        break;
                    case 4:
                        mIngredient.setType("spices");
                        break;
                    default:
                        mIngredient.setType("veggies");
                        break;
                }
                Date newDate = new Date();
                mIngredient.setExpDate(newDate);
                mIngredient.dateFromType();
            }
        });

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveIngredient();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        //String title = getArguments().getString("title", "New Ingredient");
        //getDialog().setTitle(title);

        etIngredientTitle.requestFocus();

        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    private void saveIngredient() {

        String title = etIngredientTitle.getText().toString();
        if (title != null && title.length() > 0) {
            mIngredient.setTitle(title);
        }
        if (ingredientValidated()) {
            //mCallback.saveIngredient(mIngredient);
            onAddFinishedListener listener = (onAddFinishedListener) getParentFragment();
            listener.onFilterFinish(mIngredient);
            getDialog().dismiss();
        } else {
            Toast.makeText(getActivity(), "Please fill all required fields!", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean ingredientValidated() {
        return mIngredient.getTitle() != null &&
                mIngredient.getTitle().length() > 0 &&
                mIngredient.getType() != null &&
                mIngredient.getType().length() > 0;
    }

    public interface onAddFinishedListener {
        void onFilterFinish(Ingredient ingredient);
    }
}
