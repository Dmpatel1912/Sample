package com.projectactivity.deep.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sysdata.widget.accordion.ExpandableItemHolder;
import com.sysdata.widget.accordion.FancyAccordionView;
import com.sysdata.widget.accordion.Item;
import com.sysdata.widget.accordion.ItemAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FAQActivity extends AppCompatActivity {

    private static final String KEY_EXPANDED_ID = "expandedId";

    private FancyAccordionView mRecyclerView;

    private ItemAdapter.OnItemClickedListener mListener = new ItemAdapter.OnItemClickedListener() {
        @Override
        public void onItemClicked(ItemAdapter.ItemViewHolder<?> viewHolder, int id) {
/*          ItemAdapter.ItemHolder itemHolder = viewHolder.getItemHolder();
            SampleItem item = ((SampleItem) itemHolder.item);

            switch (id) {
                case ItemAdapter.OnItemClickedListener.ACTION_ID_COLLAPSED_VIEW:
                    showToast(String.format("Collapsed %s clicked!", item.getTitle()));
                    break;
                case ItemAdapter.OnItemClickedListener.ACTION_ID_EXPANDED_VIEW:
                    showToast(String.format("Expanded %s clicked!", item.getTitle()));
                    break;
                default:
                    // do nothing
                    break;
            }
*/
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        setTitle("FAQ");

        mRecyclerView = (FancyAccordionView) findViewById(R.id.alarms_recycler_view);

// bind the factory to create view holder for item collapsed
        mRecyclerView.setCollapsedViewHolderFactory(SampleCollapsedViewHolder.Factory.create(R.layout.sample_layout_collapsed), mListener);

// bind the factory to create view holder for item expanded
        mRecyclerView.setExpandedViewHolderFactory(SampleExpandedViewHolder.Factory.create(R.layout.sample_layout_expanded), mListener);

// restore the expanded item from state
        if (savedInstanceState != null) {
            mRecyclerView.setExpandedItemId(savedInstanceState.getLong(KEY_EXPANDED_ID, Item.INVALID_ID));
        }

// populate RecyclerView with mock data
        loadData();
    }

        /*private void loadData() {
            final List<ExpandableItemHolder> itemHolders = new ArrayList<>();
            Item itemModel;
            ExpandableItemHolder itemHolder;
            itemModel = SampleItem.create("how is it work ?","Scan Your Identity Card for your complain");
            itemHolder = new ExpandableItemHolder(itemModel);
            itemHolders.add(itemHolder);
        }
        mRecyclerView.setAdapterItems(itemHolders);*/

        private void loadData() {
        final int dataCount = 50;
        int index = 0;

        final List<ExpandableItemHolder> itemHolders = new ArrayList<>(dataCount);
        Item itemModel;
        ExpandableItemHolder itemHolder;
        for (; index < dataCount; index++) {
            itemModel = SampleItem.create(getItemTitle(index), getItemDescription(index));
            itemHolder = new ExpandableItemHolder(itemModel);
            itemHolders.add(itemHolder);
        }

        mRecyclerView.setAdapterItems(itemHolders);
    }

    private String getItemTitle(int position) {
        return String.format(Locale.ENGLISH, "Item %d", position + 1);
    }

    private String getItemDescription(int position) {
        return String.format(Locale.ENGLISH, "Hello World, I'm an expandable item!", position);
    }

}
