package com.rujira.arcoresceneform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.Color;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArFragment arFragment;
    private ModelRenderable bearRenderable,
            catRenderable,
            cowRenderable,
            dogRenderable,
            elephantRenderable,
            ferretRenderable,
            hippoRenderable,
            horseRenderable,
            koalaRenderable,
            lionRenderable;
    ImageView bear, cat, cow, dog, elephant, ferret, hippo, horse, koala, lion;

    View arrayView[];
    ViewRenderable name_animal;

    int selected = 1; // Default Bear is choose
    ViewRenderable animal_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.sceneform_ux_fragment);

        // View
        bear = (ImageView) findViewById(R.id.bear);
        cat = (ImageView) findViewById(R.id.cat);
        cow = (ImageView) findViewById(R.id.cow);
        dog = (ImageView) findViewById(R.id.dog);
        elephant = (ImageView) findViewById(R.id.elephant);
        ferret = (ImageView) findViewById(R.id.ferret);
        hippo = (ImageView) findViewById(R.id.hippopotamus);
        horse = (ImageView) findViewById(R.id.horse);
        koala = (ImageView) findViewById(R.id.koala_bear);
        lion = (ImageView) findViewById(R.id.lion);

        setArrayView();
        setClickListener();

        setupModel();
        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                // When user tap on place, we will add model

                Anchor anchor = hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);
                anchorNode.setParent(arFragment.getArSceneView().getScene());

                createModel(anchorNode, selected);

            }
        });
    }

    private void setupModel() {

        ViewRenderable.builder()
                .setView(this, R.layout.name_animal)
                .build()
                .thenAccept(renderable -> name_animal = renderable);

        ModelRenderable.builder()
                .setSource(this, R.raw.bear)
                .build().thenAccept(renderable -> bearRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unnable to load bear model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.cat)
                .build().thenAccept(renderable -> catRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unnable to load bear model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.cow)
                .build().thenAccept(renderable -> cowRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unnable to load bear model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.dog)
                .build().thenAccept(renderable -> dogRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unnable to load bear model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.elephant)
                .build().thenAccept(renderable -> elephantRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unnable to load bear model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.ferret)
                .build().thenAccept(renderable -> ferretRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unnable to load bear model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.hippopotamus)
                .build().thenAccept(renderable -> hippoRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unnable to load bear model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.horse)
                .build().thenAccept(renderable -> horseRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unnable to load bear model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.koala_bear)
                .build().thenAccept(renderable -> koalaRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unnable to load bear model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.lion)
                .build().thenAccept(renderable -> lionRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unnable to load bear model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
    }

    private void createModel(AnchorNode anchorNode, int selected) {
        if (selected == 1) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(bearRenderable);
            bear.select();

            addName(anchorNode, bear, "Bear");
        }
        if (selected == 2) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(catRenderable);
            bear.select();

            addName(anchorNode, bear, "Cat");
        }
        if (selected == 3) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(cowRenderable);
            bear.select();

            addName(anchorNode, bear, "Cow");
        }
        if (selected == 4) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(dogRenderable);
            bear.select();

            addName(anchorNode, bear, "Dog");
        }
        if (selected == 5) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(elephantRenderable);
            bear.select();

            addName(anchorNode, bear, "Elephant");
        }
        if (selected == 6) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(ferretRenderable);
            bear.select();

            addName(anchorNode, bear, "Ferret");
        }
        if (selected == 7) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(hippoRenderable);
            bear.select();

            addName(anchorNode, bear, "Hippo");
        }
        if (selected == 8) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(horseRenderable);
            bear.select();

            addName(anchorNode, bear, "Horse");
        }
        if (selected == 9) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(koalaRenderable);
            bear.select();

            addName(anchorNode, bear, "Koala");
        }
        if (selected == 10) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(lionRenderable);
            bear.select();

            addName(anchorNode, bear, "Lion");
        }
    }

    private void addName(AnchorNode anchorNode, TransformableNode model, String name) {
        TransformableNode nameView = new TransformableNode(arFragment.getTransformationSystem());
        nameView.setLocalPosition(new Vector3(0f, model.getLocalPosition().y + 0.5f, 0));
        nameView.setParent(anchorNode);
        nameView.setRenderable(name_animal);
        nameView.select();

        // Set Text
        TextView txt_name = (TextView) name_animal.getView();
        txt_name.setText(name);

        // Click to text view to remove animal
        txt_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anchorNode.setParent(null);
            }
        });
    }

    private void setClickListener() {
        for (int i = 0; i < arrayView.length; i++) {
            arrayView[i].setOnClickListener(this);
        }
    }

    private void setArrayView() {
        arrayView = new View[]{
                bear, cat, cow, dog, elephant, ferret, hippo, horse, koala, lion
        };
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bear) {
            selected = 1;
            setBackgroud(view.getId());
        } else if (view.getId() == R.id.cat) {
            selected = 2;
            setBackgroud(view.getId());
        } else if (view.getId() == R.id.cow) {
            selected = 3;
            setBackgroud(view.getId());
        } else if (view.getId() == R.id.dog) {
            selected = 4;
            setBackgroud(view.getId());
        } else if (view.getId() == R.id.elephant) {
            selected = 5;
            setBackgroud(view.getId());
        } else if (view.getId() == R.id.ferret) {
            selected = 6;
            setBackgroud(view.getId());
        } else if (view.getId() == R.id.hippopotamus) {
            selected = 7;
            setBackgroud(view.getId());
        } else if (view.getId() == R.id.horse) {
            selected = 8;
            setBackgroud(view.getId());
        } else if (view.getId() == R.id.koala_bear) {
            selected = 9;
            setBackgroud(view.getId());
        } else if (view.getId() == R.id.lion) {
            selected = 10;
            setBackgroud(view.getId());
        }


    }

    private void setBackgroud(int id) {
        for (int i = 0; i < arrayView.length; i++) {
            if (arrayView[i].getId() == id)
                arrayView[i].setBackgroundColor(android.graphics.Color.parseColor("#80333639"));
            else
                arrayView[i].setBackgroundColor(ContextCompat.getColor(this,
                        android.R.color.transparent));


        }
    }
}
